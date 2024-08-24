package com.example.instagram.model

data class PostModel(var profileUser:Int?=null,
                     var userImage:Int?=null,
                     var userName:String?=null,
                     var likeCount:Int?=null,
                     var comments:String?=null,
                     var isExpanded: Boolean = false)