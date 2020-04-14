package jp.chau2chaun2.honkot.sample.multimodule.repository

import android.content.Context
import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import jp.chau2chaun2.honkot.sample.multimodule.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepository @Inject constructor(
    private val context: Context
) {
    suspend fun loadImage(path: String): Bitmap = withContext(Dispatchers.IO) {
        Picasso.with(context)
            .load(path)
            .error(R.mipmap.ic_launcher)
            .get()
    }
}
