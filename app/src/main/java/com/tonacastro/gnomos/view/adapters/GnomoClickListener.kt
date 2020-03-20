package com.tonacastro.gnomos.view.adapters

import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
interface GnomoClickListener {
    fun gnomoClicked(service: GnomoModel)
}