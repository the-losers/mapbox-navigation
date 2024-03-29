package com.mapbox.services.android.navigation.v5.internal.navigation.metrics

import android.os.Build
import android.os.Parcel
import com.mapbox.android.telemetry.Event
import com.mapbox.services.android.navigation.BuildConfig

/**
 * Base Event class for navigation events, contains common properties.
 */
internal abstract class NavigationEvent(
    phoneState: PhoneState
) : Event() {

    companion object {
        private val OPERATING_SYSTEM = "Android - ${Build.VERSION.RELEASE}"
    }

    val operatingSystem: String = OPERATING_SYSTEM
    val device: String? = Build.MODEL
    val sdkVersion: String = BuildConfig.MAPBOX_NAVIGATION_VERSION_NAME
    val created: String = phoneState.created
    val volumeLevel: Int = phoneState.volumeLevel
    val batteryLevel: Int = phoneState.batteryLevel
    val screenBrightness: Int = phoneState.screenBrightness
    val batteryPluggedIn: Boolean = phoneState.isBatteryPluggedIn
    val connectivity: String = phoneState.connectivity
    val audioType: String = phoneState.audioType
    val applicationState: String = phoneState.applicationState
    val event: String = getEventName()

    var startTimestamp: String? = null
    var sdkIdentifier: String? = null
    var sessionIdentifier: String? = null
    var geometry: String? = null
    var profile: String? = null
    var originalRequestIdentifier: String? = null
    var requestIdentifier: String? = null
    var originalGeometry: String? = null
    var locationEngine: String? = null
    var tripIdentifier: String? = null
    var lat: Double = 0.toDouble()
    var lng: Double = 0.toDouble()
    var simulation: Boolean = false
    var absoluteDistanceToDestination: Int = 0
    var percentTimeInPortrait: Int = 0
    var percentTimeInForeground: Int = 0
    var distanceCompleted: Int = 0
    var distanceRemaining: Int = 0
    var durationRemaining: Int = 0
    var eventVersion: Int = 0
    var estimatedDistance: Int = 0
    var estimatedDuration: Int = 0
    var rerouteCount: Int = 0
    var originalEstimatedDistance: Int = 0
    var originalEstimatedDuration: Int = 0
    var stepCount: Int = 0
    var originalStepCount: Int = 0
    var legIndex: Int = 0
    var legCount: Int = 0
    var stepIndex: Int = 0
    var voiceIndex: Int = 0
    var bannerIndex: Int = 0
    var totalStepCount: Int = 0

    internal abstract fun getEventName(): String

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
    }
}
