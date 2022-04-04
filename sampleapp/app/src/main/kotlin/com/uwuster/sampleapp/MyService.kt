package com.uwuster.sampleapp

import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.uwuster.floatie.*
import com.uwuster.floatie.view.*
import com.uwuster.sampleapp.R

class MyService: FloatieService(), IFloatieDraggableWindowItemEventListener, IFloatieInteractionListener {

    override fun createFloatie(): Floatie {
        return Floatie.Builder()
            .with(this)
            .setDraggableItem(createDraggableItem())
            .setRemoveItem(createRemoveItem())
            .setListener(this)
            .build()
    }

    private fun createDraggableItem(): FloatieDraggableItem {
        val draggableViewLayout = LayoutInflater.from(this).inflate(R.layout.draggable_view, null)

        return FloatieDraggableItem.Builder()
            .setLayout(draggableViewLayout)
            .setGravity(DraggableWindowItemGravity.TOP_LEFT)
            .setListener(this)
            .build()
    }

    private fun createRemoveItem(): FloatieRemoveItem {
        return FloatieRemoveItem.Builder()
            .with(this)
            .setShouldFollowDrag(true)
            .setExpandable(true)
            .build()
    }

    override fun onTouchEventChanged(
        view: View,
        currentViewPosition: Point,
        currentTouchPoint: Point,
        velocityX: Float,
        velocityY: Float,
        draggableWindowItemTouchEvent: DraggableWindowItemTouchEvent
    ) {
        when (draggableWindowItemTouchEvent) {
            DraggableWindowItemTouchEvent.CLICK_EVENT -> {

            }
            DraggableWindowItemTouchEvent.DRAG_EVENT -> {
                val imageView = view.findViewById<ImageView>(R.id.draggable_view)
                if (imageView.drawable != getDrawable(R.drawable.bojji_drag)) {
                    imageView.setImageDrawable(getDrawable(R.drawable.bojji_drag))
                }
            }
            DraggableWindowItemTouchEvent.DRAG_STOP_EVENT -> {
                view.findViewById<ImageView>(R.id.draggable_view).setImageDrawable(getDrawable(R.drawable.bojji))
            }
        }
    }

    override fun onOverlappingRemoveItemOnDrag(
        removeItem: FloatieRemoveItem,
        draggableItem: FloatieDraggableItem
    ) {
        val imageView = draggableItem.view.findViewById<ImageView>(R.id.draggable_view)
        if (imageView.drawable != getDrawable(R.drawable.bojji_remove)) {
            imageView.setImageDrawable(getDrawable(R.drawable.bojji_remove))
        }
    }

    override fun onNotOverlappingRemoveItemOnDrag(
        removeItem: FloatieRemoveItem,
        draggableItem: FloatieDraggableItem
    ) {
        val imageView = draggableItem.view.findViewById<ImageView>(R.id.draggable_view)
        if (imageView.drawable != getDrawable(R.drawable.bojji_drag)) {
            imageView.setImageDrawable(getDrawable(R.drawable.bojji_drag))
        }
    }

    override fun onDropInRemoveItem(
        removeItem: FloatieRemoveItem,
        draggableItem: FloatieDraggableItem
    ) {
        // Nothing to do
    }
}