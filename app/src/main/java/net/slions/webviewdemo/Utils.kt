package net.slions.webviewdemo

import android.view.View
import android.view.ViewGroup

/**
 * Removes a view from its parent if it has one.
 * WARNING: This may not set this parent to null instantly if you are using animateLayoutChanges.
 */
fun View.removeFromParent() : ViewGroup? {
    val vg = (parent as? ViewGroup)
    vg?.removeView(this)
    return vg
}