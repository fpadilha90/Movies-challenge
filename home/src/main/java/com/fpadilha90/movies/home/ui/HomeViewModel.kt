package com.fpadilha90.movies.home.ui

import android.R
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.domain.exception.Failure
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.home.repository.MovieRepository
import kotlinx.coroutines.*

class HomeViewModel(movieRepository : MovieRepository) : ViewModel() {
    val movies = MutableLiveData<List<Movie>>()

    init {

        GlobalScope.launch(Dispatchers.Main) {
            movieRepository.getPopularTVShows().either(::handleError) {
                movies.value = it
            }
        }

//        movies.value = arrayListOf(
//            Movie("https://www.ubackground.com/_ph/22/673076330.jpg", 5.0, 1, "https://www.ubackground.com/_ph/22/673076330.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 5.0, 1, "https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://wallpapercave.com/wp/wp3891830.jpg", 5.0, 1, "https://wallpapercave.com/wp/wp3891830.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://www.ubackground.com/_ph/22/673076330.jpg", 5.0, 1, "https://www.ubackground.com/_ph/22/673076330.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 5.0, 1, "https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://wallpapercave.com/wp/wp3891830.jpg", 5.0, 1, "https://wallpapercave.com/wp/wp3891830.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://www.ubackground.com/_ph/22/673076330.jpg", 5.0, 1, "https://www.ubackground.com/_ph/22/673076330.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 5.0, 1, "https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://wallpapercave.com/wp/wp3891830.jpg", 5.0, 1, "https://wallpapercave.com/wp/wp3891830.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://www.ubackground.com/_ph/22/673076330.jpg", 5.0, 1, "https://www.ubackground.com/_ph/22/673076330.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 5.0, 1, "https://www.desktopbackground.org/download/1280x1024/2014/03/02/725214_free-download-marvel-comic-the-avengers-wallpapers-movie-04-26253_1728x1080_h.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://wallpapercave.com/wp/wp3891830.jpg", 5.0, 1, "https://wallpapercave.com/wp/wp3891830.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4"),Movie("https://wallpaperaccess.com/full/267638.jpg", 5.0, 1, "https://wallpaperaccess.com/full/267638.jpg", 4.0, "Teste", "Movie 1"),
//            Movie("https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.0, 2, "https://terrigen-cdn-dev.marvel.com/content/prod/1x/theavengers_lob_mas_dsk_03_1.jpg", 4.2, "Teste", "Movie 2"),
//            Movie("https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200",3.6, 3, "https://lumiere-a.akamaihd.net/v1/images/eu_cma_hero_r_cba73c74.jpeg?region=0,0,2000,835&width=1200", 5.0, "Teste", "Movie 3"),
//            Movie("https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.5, 4, "https://images5.alphacoders.com/698/thumb-1920-698123.jpg", 4.3, "Teste", "Movie 4")
//        )
    }

    private fun handleError(failure: Failure) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}