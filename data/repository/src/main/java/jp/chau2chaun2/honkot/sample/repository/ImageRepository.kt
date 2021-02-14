package jp.chau2chaun2.honkot.sample.repository

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepository @Inject constructor(
    private val context: Context,
    private val resources: Resources
) {
    suspend fun loadImage(path: String?): Bitmap? = withContext(Dispatchers.IO) {
        return@withContext if (path?.isEmpty() == true) {
            BitmapFactory.decodeResource(resources, R.drawable.ic_none)
        } else {
            try {
                Picasso.with(context)
                    .load(path)
                    .error(R.drawable.ic_none)
                    .get()
            } catch (e: Exception) {
                BitmapFactory.decodeResource(resources, R.drawable.ic_none)
            }
        }
    }
}
