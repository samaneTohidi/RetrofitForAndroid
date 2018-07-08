package com.example.papyrus.retrofitforandroid.Models




data class PostWithPhotos(
    val status: String,
    val count: Int,
    val count_total: Int,
    val pages: Int,
    val posts: List<Post>,
    val query: Query
)

data class Post(
    val id: Int,
    val type: String,
    val slug: String,
    val url: String,
    val status: String,
    val title: String,
    val title_plain: String,
    val content: String,
    val excerpt: String,
    val date: String,
    val modified: String,
    val categories: List<Category>,
    val tags: List<Any>,
    val author: Author,
    val comments: List<Any>,
    val attachments: List<Attachment>,
    val comment_count: Int,
    val comment_status: String,
    val thumbnail: String,
    val custom_fields: CustomFields,
    val thumbnail_size: String,
    val thumbnail_images: ThumbnailImages
)

data class Category(
    val id: Int,
    val slug: String,
    val title: String,
    val description: String,
    val parent: Int,
    val post_count: Int
)

data class CustomFields(val test:String
)

data class ThumbnailImages(
    val full: Full,
    val thumbnail: Thumbnail,
    val medium: Medium,
    val medium_large: MediumLarge,
    val large: Large,
    val smallThumb: SmallThumb,
    val featuredImage: FeaturedImage
)

data class SmallThumb(
    val url: String,
    val width: Int,
    val height: Int
)

data class Thumbnail(
    val url: String,
    val width: Int,
    val height: Int
)

data class MediumLarge(
    val url: String,
    val width: Int,
    val height: Int
)

data class Full(
    val url: String,
    val width: Int,
    val height: Int
)

data class Large(
    val url: String,
    val width: Int,
    val height: Int
)

data class Medium(
    val url: String,
    val width: Int,
    val height: Int
)

data class FeaturedImage(
    val url: String,
    val width: Int,
    val height: Int
)

data class Author(
    val id: Int,
    val slug: String,
    val name: String,
    val first_name: String,
    val last_name: String,
    val nickname: String,
    val url: String,
    val description: String
)

data class Attachment(
    val id: Int,
    val url: String,
    val slug: String,
    val title: String,
    val description: String,
    val caption: String,
    val parent: Int,
    val mime_type: String,
    val images: Images
)

data class Images(
    val full: Full,
    val thumbnail: Thumbnail,
    val medium: Medium,
    val medium_large: MediumLarge,
    val large: Large,
    val smallThumb: SmallThumb,
    val featuredImage: FeaturedImage
)

data class Query(
    val ignore_sticky_posts: Boolean
)