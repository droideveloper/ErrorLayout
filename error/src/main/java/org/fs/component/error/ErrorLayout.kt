/*
 * Error Layout Android Kotlin Copyright (C) 2018 Fatih, Open Source.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fs.component.error

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.widget.TextViewCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import kotlinx.android.synthetic.main.view_error_layout.view.*

class ErrorLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, style: Int = 0): ConstraintLayout(context, attrs, style) {

  init {
    View.inflate(context, R.layout.view_error_layout, this)
    // read attrs
    context.obtainStyledAttributes(attrs, R.styleable.ErrorLayout).apply {
      // title
      val titleTextAppearance = getResourceId(R.styleable.ErrorLayout_errorLayout_titleTextAppearance, -1)
      if (titleTextAppearance != -1) {
        TextViewCompat.setTextAppearance(viewErrorTextTitle, titleTextAppearance)
      }
      val titleTextSize = getDimension(R.styleable.ErrorLayout_errorLayout_titleTextSize, -1f)
      if (titleTextSize != -1f) {
        viewErrorTextTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleTextSize)
      }
      val titleTextColor = getResourceId(R.styleable.ErrorLayout_errorLayout_titleTextColor, -1)
      if (titleTextColor != -1) {
        viewErrorTextTitle.setTextColor(ResourcesCompat.getColor(resources, titleTextColor, context.theme))
      }
      val titleText = getString(R.styleable.ErrorLayout_errorLayout_title)
      viewErrorTextTitle.text = titleText
      // subtitle
      val subTitleTextAppearance = getResourceId(R.styleable.ErrorLayout_errorLayout_subTitleTextAppearance, -1)
      if (subTitleTextAppearance != -1) {
        TextViewCompat.setTextAppearance(viewErrorTextSubTitle, subTitleTextAppearance)
      }
      val subTitleTextSize = getDimension(R.styleable.ErrorLayout_errorLayout_subTitleTextSize, -1f)
      if (subTitleTextSize != -1f) {
        viewErrorTextSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, subTitleTextSize)
      }
      val subTitleTextColor = getResourceId(R.styleable.ErrorLayout_errorLayout_subTitleTextColor, -1)
      if (subTitleTextColor != -1) {
        viewErrorTextSubTitle.setTextColor(ResourcesCompat.getColor(resources, subTitleTextColor, context.theme))
      }
      val subTitleText = getString(R.styleable.ErrorLayout_errorLayout_subTitle)
      viewErrorTextSubTitle.text = subTitleText
      // image
      val drawableRes = getResourceId(R.styleable.ErrorLayout_errorLayout_src, -1)
      if (drawableRes != -1) {
        viewImageError.setImageResource(drawableRes)
      }
      // and recycle it
      recycle()
    }
  }
}