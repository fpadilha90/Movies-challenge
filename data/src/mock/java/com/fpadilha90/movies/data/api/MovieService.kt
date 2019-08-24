package com.fpadilha90.movies.data.api

import com.fpadilha90.movies.data.model.GetPopularDTO
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import java.lang.reflect.Type

class MovieServiceMock : MovieService {


    override fun getPopular(apiKey: String): Deferred<Response<GetPopularDTO>> {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<GetPopularDTO> = moshi.adapter(GetPopularDTO::class.java)

        return CompletableDeferred(Response.success(
            adapter.fromJson(getPopularMock)))

    }

    companion object {
        const val getPopularMock = "{\n" +
                "  \"page\": 1,\n" +
                "  \"total_results\": 10000,\n" +
                "  \"total_pages\": 500,\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"original_name\": \"The Flash\",\n" +
                "      \"id\": 60735,\n" +
                "      \"name\": \"The Flash\",\n" +
                "      \"popularity\": 345.08,\n" +
                "      \"vote_count\": 2803,\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"first_air_date\": \"2014-10-07\",\n" +
                "      \"poster_path\": \"/fki3kBlwJzFp8QohL43g9ReV455.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"backdrop_path\": \"/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg\",\n" +
                "      \"overview\": \"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.\",\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Family Guy\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        35\n" +
                "      ],\n" +
                "      \"name\": \"Family Guy\",\n" +
                "      \"popularity\": 215.683,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 1608,\n" +
                "      \"first_air_date\": \"1999-01-31\",\n" +
                "      \"backdrop_path\": \"/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 1434,\n" +
                "      \"vote_average\": 6.5,\n" +
                "      \"overview\": \"Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.\",\n" +
                "      \"poster_path\": \"/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Arrow\",\n" +
                "      \"id\": 1412,\n" +
                "      \"name\": \"Arrow\",\n" +
                "      \"popularity\": 228.471,\n" +
                "      \"vote_count\": 2599,\n" +
                "      \"vote_average\": 5.8,\n" +
                "      \"first_air_date\": \"2012-10-10\",\n" +
                "      \"poster_path\": \"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        18,\n" +
                "        9648,\n" +
                "        10759\n" +
                "      ],\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"backdrop_path\": \"/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg\",\n" +
                "      \"overview\": \"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\",\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Fear the Walking Dead\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        27\n" +
                "      ],\n" +
                "      \"name\": \"Fear the Walking Dead\",\n" +
                "      \"popularity\": 202.409,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 998,\n" +
                "      \"first_air_date\": \"2015-08-23\",\n" +
                "      \"backdrop_path\": \"/nUXzdD2Jo3wV9Q7mIZjK46Yyty4.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 62286,\n" +
                "      \"vote_average\": 6.3,\n" +
                "      \"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\",\n" +
                "      \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"13 Reasons Why\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        9648\n" +
                "      ],\n" +
                "      \"name\": \"13 Reasons Why\",\n" +
                "      \"popularity\": 181.286,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 840,\n" +
                "      \"first_air_date\": \"2017-03-31\",\n" +
                "      \"backdrop_path\": \"/sZb21d6EWKAEKZ9GrLQeMwX4cWN.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 66788,\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"overview\": \"After a teenage girl's perplexing suicide, a classmate receives a series of tapes that unravel the mystery of her tragic choice.\",\n" +
                "      \"poster_path\": \"/nel144y4dIOdFFid6twN5mAX9Yd.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Grey's Anatomy\",\n" +
                "      \"id\": 1416,\n" +
                "      \"name\": \"Grey's Anatomy\",\n" +
                "      \"popularity\": 156.958,\n" +
                "      \"vote_count\": 992,\n" +
                "      \"vote_average\": 6.3,\n" +
                "      \"first_air_date\": \"2005-03-27\",\n" +
                "      \"poster_path\": \"/eqgIOObafPJitt8JNh1LuO2fvqu.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18\n" +
                "      ],\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"backdrop_path\": \"/hF9yq8MxaTNLJITo0lwgO7eUoTx.jpg\",\n" +
                "      \"overview\": \"Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.\",\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"The Simpsons\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        35\n" +
                "      ],\n" +
                "      \"name\": \"The Simpsons\",\n" +
                "      \"popularity\": 168.757,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 2100,\n" +
                "      \"first_air_date\": \"1989-12-17\",\n" +
                "      \"backdrop_path\": \"/1pP0gg0iNGX06wSs19EQOvzfZIF.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 456,\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"overview\": \"Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.\",\n" +
                "      \"poster_path\": \"/yTZQkSsxUFJZJe67IenRM0AEklc.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Supernatural\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        9648,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"Supernatural\",\n" +
                "      \"popularity\": 145.588,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 1886,\n" +
                "      \"first_air_date\": \"2005-09-13\",\n" +
                "      \"backdrop_path\": \"/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 1622,\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"overview\": \"When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. \",\n" +
                "      \"poster_path\": \"/3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"ナルト 疾風伝\",\n" +
                "      \"id\": 31910,\n" +
                "      \"name\": \"Naruto Shippūden\",\n" +
                "      \"popularity\": 133.187,\n" +
                "      \"vote_count\": 241,\n" +
                "      \"vote_average\": 7.6,\n" +
                "      \"first_air_date\": \"2007-02-15\",\n" +
                "      \"poster_path\": \"/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        35,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"original_language\": \"ja\",\n" +
                "      \"backdrop_path\": \"/c14vjmndzL9tBdooGsMznMFrFLo.jpg\",\n" +
                "      \"overview\": \"Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.\",\n" +
                "      \"origin_country\": [\n" +
                "        \"JP\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Two and a Half Men\",\n" +
                "      \"genre_ids\": [\n" +
                "        35\n" +
                "      ],\n" +
                "      \"name\": \"Two and a Half Men\",\n" +
                "      \"popularity\": 98.169,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 724,\n" +
                "      \"first_air_date\": \"2003-09-21\",\n" +
                "      \"backdrop_path\": \"/27cshLy9anL9G0g6tBQjWkPACx5.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 2691,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"overview\": \"A hedonistic jingle writer's free-wheeling life comes to an abrupt halt when his brother and 10-year-old nephew move into his beach-front house.\",\n" +
                "      \"poster_path\": \"/A9QDK4OWpv41W27kCv0LXe30k9S.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Law & Order: Special Victims Unit\",\n" +
                "      \"id\": 2734,\n" +
                "      \"name\": \"Law & Order: Special Victims Unit\",\n" +
                "      \"popularity\": 126.711,\n" +
                "      \"vote_count\": 653,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"first_air_date\": \"1999-09-20\",\n" +
                "      \"poster_path\": \"/ydSvHgksuB8Ix0V05QEZBKrnIcg.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"backdrop_path\": \"/kOvt2BOOwSAQCT8yo3pM3X2GXjh.jpg\",\n" +
                "      \"overview\": \"In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.\",\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"The Boys\",\n" +
                "      \"genre_ids\": [\n" +
                "        10759,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"The Boys\",\n" +
                "      \"popularity\": 128.239,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 137,\n" +
                "      \"first_air_date\": \"2019-07-25\",\n" +
                "      \"backdrop_path\": \"/bI37vIHSH7o4IVkq37P8cfxQGMx.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 76479,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"overview\": \"A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.\",\n" +
                "      \"poster_path\": \"/dzOxNbbz1liFzHU1IPvdgUR647b.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Marvel's Agents of S.H.I.E.L.D.\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        10759,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"Marvel's Agents of S.H.I.E.L.D.\",\n" +
                "      \"popularity\": 133.66,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 1349,\n" +
                "      \"first_air_date\": \"2013-09-24\",\n" +
                "      \"backdrop_path\": \"/iWopHyAvuIDjGX10Yc3nn6UEebW.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 1403,\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"overview\": \"Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.\",\n" +
                "      \"poster_path\": \"/cXiETfFK1BTLest5fhTLfDLRdL6.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Stranger Things\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        9648,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"Stranger Things\",\n" +
                "      \"popularity\": 132.015,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 2559,\n" +
                "      \"first_air_date\": \"2016-07-15\",\n" +
                "      \"backdrop_path\": \"/56v2KjBlU4XaOv9rVYEQypROD7P.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 66732,\n" +
                "      \"vote_average\": 8.3,\n" +
                "      \"overview\": \"When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.\",\n" +
                "      \"poster_path\": \"/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Gotham\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        18,\n" +
                "        14\n" +
                "      ],\n" +
                "      \"name\": \"Gotham\",\n" +
                "      \"popularity\": 140.657,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 1150,\n" +
                "      \"first_air_date\": \"2014-09-22\",\n" +
                "      \"backdrop_path\": \"/mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 60708,\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"overview\": \"Before there was Batman, there was GOTHAM. \\n\\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker? \",\n" +
                "      \"poster_path\": \"/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Game of Thrones\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        10759,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"Game of Thrones\",\n" +
                "      \"popularity\": 125.354,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 6267,\n" +
                "      \"first_air_date\": \"2011-04-17\",\n" +
                "      \"backdrop_path\": \"/qsD5OHqW7DSnaQ2afwz8Ptht1Xb.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 1399,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"overview\": \"Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.\",\n" +
                "      \"poster_path\": \"/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Legion\",\n" +
                "      \"genre_ids\": [\n" +
                "        10759,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"Legion\",\n" +
                "      \"popularity\": 124.808,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 603,\n" +
                "      \"first_air_date\": \"2017-02-08\",\n" +
                "      \"backdrop_path\": \"/87eP7ITTrOWvkA4EqCuoRdyjzLy.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 67195,\n" +
                "      \"vote_average\": 7.6,\n" +
                "      \"overview\": \"David Haller, AKA Legion, is a troubled young man who may be more than human. Diagnosed as schizophrenic, David has been in and out of psychiatric hospitals for years. But after a strange encounter with a fellow patient, he’s confronted with the possibility that the voices he hears and the visions he sees might be real.\",\n" +
                "      \"poster_path\": \"/vT0Zsbm4GWd7llNjgWEtwY0CqOv.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"South Park\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        35\n" +
                "      ],\n" +
                "      \"name\": \"South Park\",\n" +
                "      \"popularity\": 114.596,\n" +
                "      \"origin_country\": [\n" +
                "        \"US\"\n" +
                "      ],\n" +
                "      \"vote_count\": 1118,\n" +
                "      \"first_air_date\": \"1997-08-13\",\n" +
                "      \"backdrop_path\": \"/mSDKNVvDfitFE6Fb6fSSl5DQmgS.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"id\": 2190,\n" +
                "      \"vote_average\": 7.8,\n" +
                "      \"overview\": \"Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.\",\n" +
                "      \"poster_path\": \"/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"七つの大罪\",\n" +
                "      \"id\": 62104,\n" +
                "      \"name\": \"The Seven Deadly Sins\",\n" +
                "      \"popularity\": 110.169,\n" +
                "      \"vote_count\": 115,\n" +
                "      \"vote_average\": 7.9,\n" +
                "      \"first_air_date\": \"2014-10-05\",\n" +
                "      \"poster_path\": \"/gxTojpKEOtue85EEFlozwRbDXwJ.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        10759,\n" +
                "        16,\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"original_language\": \"ja\",\n" +
                "      \"backdrop_path\": \"/n5Ty1KJIRNCXlDHDjcPpUgp57tr.jpg\",\n" +
                "      \"overview\": \"The “Seven Deadly Sins”—a group of evil knights who conspired to overthrow the kingdom of Britannia—were said to have been eradicated by the Holy Knights, although some claim that they still live. Ten years later, the Holy Knights have staged a Coup d'état and assassinated the king, becoming the new, tyrannical rulers of the kingdom. Elizabeth, the king's only daughter, sets out on a journey to find the “Seven Deadly Sins,” and to enlist their help in taking back the kingdom.\",\n" +
                "      \"origin_country\": [\n" +
                "        \"JP\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"original_name\": \"Лучше, чем люди\",\n" +
                "      \"genre_ids\": [\n" +
                "        10765\n" +
                "      ],\n" +
                "      \"name\": \"Better Than Us\",\n" +
                "      \"popularity\": 98.301,\n" +
                "      \"origin_country\": [\n" +
                "        \"RU\"\n" +
                "      ],\n" +
                "      \"vote_count\": 11,\n" +
                "      \"first_air_date\": \"2018-11-23\",\n" +
                "      \"backdrop_path\": \"/sgKWm5B1SjlhxQJpsJpT1IEwUtR.jpg\",\n" +
                "      \"original_language\": \"ru\",\n" +
                "      \"id\": 84380,\n" +
                "      \"vote_average\": 7,\n" +
                "      \"overview\": \"Moscow in a not so distant future where human beings share their daily lives with robots. Georgy, a forensic who has a robot assistant, suddenly finds himself caught up in the first murder committed by a new kind of experimental humanoid.\",\n" +
                "      \"poster_path\": \"/dUigUEoz7IlImY4uJLtqnLRYEU3.jpg\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n"
    }

}