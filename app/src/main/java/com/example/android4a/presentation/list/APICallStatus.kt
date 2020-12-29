package com.example.android4a.presentation.list

import com.example.android4a.domain.entity.KKSong

sealed class APICallStatus
data class APICallSuccess(val kkSongList: List<KKSong>):APICallStatus()
object APICallError:APICallStatus()