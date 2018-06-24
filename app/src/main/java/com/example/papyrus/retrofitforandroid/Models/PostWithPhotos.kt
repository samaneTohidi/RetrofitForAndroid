package com.example.papyrus.retrofitforandroid.Models



class PostWithPhotos {
    var count: String? = null

    var status: String? = null

    var pages: String? = null

    var posts: Array<Posts>? = null

    var count_total: String? = null




}


class Posts {
    var custom_fields: String? = null

    var comment_count: String? = null

    var tags: Array<Tags>? = null

    var status: String? = null

    var excerpt: String? = null

    var comment_status: String? = null

    var type: String? = null

    var date: String? = null

    var url: String? = null

    var modified: String? = null

    var id: String? = null

    var content: String? = null

    var author: Author? = null

    var title: String? = null

    var thumbnail: String? = null

    var thumbnail_size: String? = null

    var thumbnail_images: Thumbnail_images? = null

    var slug: String? = null

    var categories: Array<Categories>? = null

    var attachments: Array<Attachments>? = null

    var comments: Array<Comments>? = null

    var title_plain: String? = null

    fun showPostid ():String{
        return id!!
    }


}


class Tags {
    var id: String? = null

    var title: String? = null

    var description: String? = null

    var post_count: String? = null

    var slug: String? = null


}

class Author {
    var id: String? = null

    var first_name: String? = null

    var nickname: String? = null

    var description: String? = null

    var name: String? = null

    var last_name: String? = null

    var slug: String? = null

    var url: String? = null


}


class Thumbnail_images {
    var thumbnail: Thumbnail? = null

    var smallThumb: SmallThumb? = null

    var full: Full? = null

    var medium_large: Medium_large? = null

    var featuredImage: FeaturedImage? = null

    var large: Large? = null

    var medium: Medium? = null


}


class Thumbnail {
    var height: String? = null

    var width: String? = null

    var url: String? = null


}

class SmallThumb{
    private var height: String? = null

    private var width: String? = null

    private var url: String? = null

    fun getHeight(): String? {
        return height
    }

    fun setHeight(height: String) {
        this.height = height
    }

    fun getWidth(): String? {
        return width
    }

    fun setWidth(width: String) {
        this.width = width
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }


}

class Full {
    var height: String? = null

    var width: String? = null

    var url: String? = null


}

class Medium_large {
    var height: String? = null

    var width: String? = null

    var url: String? = null

}

class FeaturedImage{
    private var height: String? = null

    private var width: String? = null

    private var url: String? = null

    fun getHeight(): String? {
        return height
    }

    fun setHeight(height: String) {
        this.height = height
    }

    fun getWidth(): String? {
        return width
    }

    fun setWidth(width: String) {
        this.width = width
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }



}

class Large {
    var height: String? = null

    var width: String? = null

    var url: String? = null


}


class Medium {
    var height: String? = null

    var width: String? = null

    var url: String? = null


}

class Categories {
    var id: String? = null

    var title: String? = null

    var description: String? = null

    var post_count: String? = null

    var parent: String? = null

    var slug: String? = null


}


class Attachments {
    var id: String? = null

    var title: String? = null

    var mime_type: String? = null

    var description: String? = null

    var images: Images? = null

    var parent: String? = null

    var caption: String? = null

    var slug: String? = null

    var url: String? = null


}

class Images {
    var thumbnail: Thumbnail? = null

    var smallThumb: SmallThumb? = null

    var full: Full? = null

    var medium_large: Medium_large? = null

    var featuredImage: FeaturedImage? = null

    var large: Large? = null

    var medium: Medium? = null


}

class Comments {
    var content: String? = null

    var id: String? = null

    var author: Author? = null

    var name: String? = null

    var parent: String? = null

    var date: String? = null

    var url: String? = null

}


