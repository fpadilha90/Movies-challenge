package com.fpadilha90.movies.data.db

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.fpadilha90.movies.common.model.Show
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShowDaoTest {

    private lateinit var appDb: AppDb
    @Before
    fun setUp(){

        appDb = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDb::class.java).build()
    }

    @After
    fun closeDb() {
        appDb.close()
    }

    @Test
    fun insertShowsSavesData() {
        val showMock = Show("", 1.0, 1, "", 1.0, "", "", "", 1, "", "", 1)
        val shows = listOf(showMock)
        appDb.shows().insert(shows)

        val showsDataFactory = appDb.shows().getAll()
//        assert(showDB.())
//        assertEquals(showMock, )
    }


}
