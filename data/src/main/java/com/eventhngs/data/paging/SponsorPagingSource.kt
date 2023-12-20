package com.eventhngs.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eventhngs.data.mapper.toEventNeeds
import com.eventhngs.data.remote.RemoteDataSource
import com.eventhngs.domain.model.EventNeedItem
import com.haroldadmin.cnradapter.NetworkResponse

class SponsorPagingSource(
    private val remoteDataSource: RemoteDataSource
) : PagingSource<Int, EventNeedItem>() {

    companion object {
        const val DEFAULT_PAGE = 0
        const val DEFAULT_SIZE = 15
    }

    override fun getRefreshKey(state: PagingState<Int, EventNeedItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EventNeedItem> {
        return try {
            val page = params.key ?: DEFAULT_PAGE
            val size = params.loadSize
            val response = remoteDataSource.getSponsor(size, page)
            when (response) {
                is NetworkResponse.Success -> {
                    val data = response.body.data?.data?.toEventNeeds() ?: emptyList()
                    val nextKey = if (data.isEmpty()) null else page + 1
                    val prevKey = if (page == DEFAULT_PAGE) null else page - 1
                    LoadResult.Page(
                        data = data,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }
                is NetworkResponse.Error -> {
                    val message = response.body?.message ?: response.error?.message
                    LoadResult.Error(
                        throwable = Throwable(message)
                    )
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}