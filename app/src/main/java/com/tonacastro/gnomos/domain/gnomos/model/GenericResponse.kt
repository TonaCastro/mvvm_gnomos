package com.tonacastro.gnomos.domain.gnomos.model

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
data class GenericResponse (var isSuccess: Boolean,
                            var message: String)

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
data class StateModel (var showLoader: Boolean,
                       var message: String)