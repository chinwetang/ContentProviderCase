package com.example.myapplication

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.core.net.toUri


class CaseContentProvider:ContentProvider() {


    companion object{

        //这里的AUTHORITY就是我们在AndroidManifest.xml中配置的authorities
        private val AUTHORITY = "com.flat.nemo"

        //匹配成功后的匹配码
        private val MATCH_CODE = 100

        //数据改变后指定通知的Uri
        private val NOTIFY_URI =
            Uri.parse("content://$AUTHORITY/case")

        //匹配不成功返回NO_MATCH(-1)
        private var uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            //添加我们需要匹配的uri
            addURI(AUTHORITY, "case", MATCH_CODE)
        }

    }


    override fun onCreate(): Boolean {
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<String?>?,
        selection: String?,
        selectionArgs: Array<String?>?,
        sortOrder: String?
    ): Cursor? {
        val match = uriMatcher.match(uri)
        return if (match == MATCH_CODE) {
           null
        } else null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        if (uriMatcher.match(uri) == MATCH_CODE) {
            notifyChange()
        }
        return "success".toUri()
    }

    override fun delete(
        uri: Uri,
        selection: String?,
        selectionArgs: Array<String?>?
    ): Int {
        if (uriMatcher.match(uri) == MATCH_CODE) {
            notifyChange()
            return 0
        }
        return 0
    }

    override fun update(
        uri: Uri,  values: ContentValues?,  selection: String?,
         selectionArgs: Array<String?>?
    ): Int {
        return 0
    }

    private fun notifyChange() {
        context!!.contentResolver.notifyChange(NOTIFY_URI, null)
    }
}