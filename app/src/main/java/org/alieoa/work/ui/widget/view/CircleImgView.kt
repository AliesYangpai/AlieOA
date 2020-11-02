package org.alieoa.work.ui.widget.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.view.marginRight
import org.alieoa.work.R

// todo 需要继续改进
class CircleImgView(private var mContext: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    View(mContext, attributeSet, defStyleAttr) {
    companion object {
        const val TAG = "CircleImgView"
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    private var mPaintBg: Paint? = null
    private var mPaintText: Paint? = null
    private var mCurrentBgColor = mContext.applicationContext.getColor(R.color.blue_bottom_circle)
    private var mCurrentTextColor = mContext.applicationContext.getColor(R.color.background)
    private var mCurrentText = "西瓜"


    private var mWidth = 0F
    private var mHeight = 0F
    private var mRadius = 0F
    private var mRectTextBound: Rect? = null

    init {
        mPaintBg = Paint().also {
            it.style = Paint.Style.FILL_AND_STROKE
            it.color = mCurrentBgColor
            it.isAntiAlias = true
        }

        mPaintText = Paint().also {
            it.color = mCurrentTextColor
            it.isAntiAlias = true
            it.textSize = 35F
        }
        mRectTextBound = Rect()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mHeight = MeasureSpec.getSize(heightMeasureSpec).toFloat()
        mRadius = mWidth / 2
        Log.i(TAG, "onMeasure==, mWidth = $mWidth mHeight = $mHeight, mRadius = $mRadius")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaintBg?.let { canvas?.drawCircle(mWidth / 2, mHeight / 2, mRadius, it) }
        mPaintText?.let {
            canvas?.drawText(
                mCurrentText,
                generateTextStartPosition()!!,
                generateTextBaselinePosition()!!,
                it
            )
        }
    }

    fun doDrawText(text: String) {
        mCurrentText = text
        invalidate()
    }

    /**
     * 生成文字左边距
     */
    private fun generateTextStartPosition(): Float? {
        mRectTextBound ?: Rect()
        mPaintText?.getTextBounds(mCurrentText, 0, mCurrentText.length, mRectTextBound)
        return mRectTextBound?.let { mWidth / 2 - it.width() / 2 }
    }

    /**
     * 生成文字绘制基线位置
     */
    private fun generateTextBaselinePosition(): Float? {
        return mPaintText?.let {
            val fontMetrics = it.fontMetrics
            val offsetOfBaseLine = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
            mHeight / 2 + offsetOfBaseLine
        }
    }


}