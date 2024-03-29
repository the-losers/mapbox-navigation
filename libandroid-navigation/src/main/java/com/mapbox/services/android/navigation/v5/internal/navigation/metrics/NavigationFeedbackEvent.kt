package com.mapbox.services.android.navigation.v5.internal.navigation.metrics

import android.annotation.SuppressLint
import android.location.Location
import com.mapbox.services.android.navigation.v5.internal.navigation.routeprogress.MetricsRouteProgress

@SuppressLint("ParcelCreator")
internal class NavigationFeedbackEvent(
    phoneState: PhoneState,
    metricsRouteProgress: MetricsRouteProgress
) : NavigationEvent(phoneState) {

    companion object {
        private const val NAVIGATION_FEEDBACK = "navigation.feedback"
    }

    /*
     * Don't remove any fields, cause they are should match with
     * the schema downloaded from S3. Look at {@link SchemaTest}
     */
    val userId: String = phoneState.userId
    val feedbackId: String = phoneState.feedbackId
    val step: NavigationStepData = NavigationStepData(metricsRouteProgress)
    var feedbackType: String? = null
    var source: String? = null
    var description: String? = null
    var locationsBefore: Array<Location>? = null
    var locationsAfter: Array<Location>? = null
    var screenshot: String? = null

    override fun getEventName(): String = NAVIGATION_FEEDBACK
}
