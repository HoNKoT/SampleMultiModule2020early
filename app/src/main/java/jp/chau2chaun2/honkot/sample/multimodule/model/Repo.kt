package jp.chau2chaun2.honkot.sample.multimodule.model

import android.provider.BaseColumns
import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Table

@Table("repos")
class Repo {
    @Column(value = BaseColumns._ID)
    @PrimaryKey(autoincrement = true)
    var id: Long = 0

    @Column
    var index: Int = 0

    @Column
    var message: String = ""

    @Column
    var colorType: ColorType = ColorType.Red
}
