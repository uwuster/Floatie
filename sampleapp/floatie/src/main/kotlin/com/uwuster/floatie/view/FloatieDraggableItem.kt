package com.uwuster.floatie.view

import android.view.*
import com.uwuster.floatie.DraggableWindowItemGravity
import com.uwuster.floatie.IFloatieDraggableWindowItemEventListener
import com.uwuster.floatie.util.DRAGGABLE_ITEM_BUIDLER_NO_LAYOUT
import com.uwuster.floatie.view.builder.IFloatieDraggableItemBuilder
import java.lang.IllegalStateException

/**
 * FloatieDraggableItem: The item that can be dragged around the screen
 */
class FloatieDraggableItem(builder: Builder) {

    val view = builder.layout
    val gravity = builder.gravity
    val startingXPosition = builder.startingXPosition
    val startingYPosition = builder.startingYPosition
    val listener = builder.listener

    /**
     * Builder that contains the construction code needed to build the draggable view
     */
    class Builder: IFloatieDraggableItemBuilder {
        lateinit var layout: View

        var gravity: DraggableWindowItemGravity = DraggableWindowItemGravity.TOP_LEFT
        var startingXPosition: Int = 0
        var startingYPosition: Int = 100

        var listener: IFloatieDraggableWindowItemEventListener? = null

        override fun setLayout(layout: View) = this.apply { this.layout = layout }

        override fun setGravity(gravity: DraggableWindowItemGravity) = this.apply { this.gravity = gravity }

        override fun setStartingXPosition(pos: Int) = this.apply { startingXPosition = pos }

        override fun setStartingYPosition(pos: Int) = this.apply { startingYPosition = pos }

        override fun setListener(listener: IFloatieDraggableWindowItemEventListener) = this.apply { this.listener = listener }

        override fun build(): FloatieDraggableItem {
            if (!this::layout.isInitialized) throw IllegalStateException(DRAGGABLE_ITEM_BUIDLER_NO_LAYOUT)

            return FloatieDraggableItem(this)
        }
    }
}