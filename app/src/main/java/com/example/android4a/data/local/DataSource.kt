package com.example.android4a.data.local

import com.example.android4a.domain.entity.KKSong

class DataSource{

    companion object{

        fun createDataSet(): ArrayList<KKSong>{
            val list = ArrayList<KKSong>()
            list.add(
                KKSong(
                    1,
                    "Agent K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/1"
                )
            )
            list.add(
                KKSong(
                    2,
                    "Aloha K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/2"
                )
            )

            list.add(
                KKSong(
                    3,
                    "Agent K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/3"
                )
            )
            list.add(
                KKSong(
                    3,
                    "Agent K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/3"
                )
            )
            list.add(
                KKSong(
                    3,
                    "Agent K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/3"
                )
            )
            list.add(
                KKSong(
                    3,
                    "Agent K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/3"
                )
            )
            list.add(
                KKSong(
                    3,
                    "Agent K.K.",
                    "https://acnhapi.com/v1/images/songs/1",
                    "https://acnhapi.com/v1/music/3"
                )
            )
            return list
        }
    }
}