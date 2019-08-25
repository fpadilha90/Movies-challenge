package com.fpadilha90.movies.home.ui

import com.fpadilha90.movies.home.repository.ShowRepository
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.fpadilha90.movies.common.model.Listing
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.common.model.Show
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private val networkStateMutableLiveData = MutableLiveData<NetworkState>()
    private val pagedList = MutableLiveData<PagedList<Show>>()
    private lateinit var listing: Listing<Show>
    private lateinit var refreshFunction: () -> Unit
    private lateinit var retryFunction: () -> Unit
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var showRepository: ShowRepository

    @Before
    fun setUp() {
        refreshFunction = mock {}
        retryFunction = mock {}
        listing = mock {
            on { refreshState } doReturn networkStateMutableLiveData
            on { networkState } doReturn networkStateMutableLiveData
            on { refresh } doReturn refreshFunction
            on { retry } doReturn retryFunction
            on { pagedList } doReturn pagedList
        }
        showRepository = mock { on { getPopularShows() } doReturn listing }
        viewModel = HomeViewModel(showRepository)
    }

    @Test
    fun pageShouldBeInitialized(){
        assertEquals(1, viewModel.page.value)
    }

    @Test
    fun repositoryShouldBeCalledAfterPageInitialization(){
        viewModel.repoResult.observeForever {  }
        verify(showRepository).getPopularShows()
    }

    @Test
    fun refreshShouldInvokeListing(){
        viewModel.repoResult.observeForever {  }
        viewModel.refresh()
        verify(refreshFunction).invoke()
    }

    @Test
    fun retryShouldInvokeListing(){
        viewModel.repoResult.observeForever {  }
        viewModel.retry()
        verify(retryFunction).invoke()
    }

    @Test
    fun moviesShouldBePopulateWithCorrectlyValue(){
        viewModel.repoResult.observeForever {  }
        viewModel.movies.observeForever {  }
        val pagedListMock = mock<PagedList<Show>> {  }
        pagedList.value = pagedListMock

        assertEquals(pagedListMock, viewModel.repoResult.value?.pagedList?.value)
    }

    @Test
    fun networkStateShouldBePopulateWithCorrectlyValue(){
        viewModel.repoResult.observeForever {  }
        viewModel.networkState.observeForever {  }
        networkStateMutableLiveData.value = NetworkState.LOADED

        assertEquals(NetworkState.LOADED, viewModel.repoResult.value?.networkState?.value)
    }

    @Test
    fun refreshStateShouldBePopulateWithCorrectlyValue(){
        viewModel.repoResult.observeForever {  }
        viewModel.refreshState.observeForever {  }
        networkStateMutableLiveData.value = NetworkState.LOADED

        assertEquals(NetworkState.LOADED, viewModel.repoResult.value?.refreshState?.value)
    }

}