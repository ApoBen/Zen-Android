/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.iconpicker

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.mozilla.fenix.R
import mozilla.components.ui.colors.R as colorsR

/**
 * Enum that represents app launcher icons available for the user to set as an alternative launcher
 * icon. For Zen Browser, we currently only support the default branded icon.
 *
 * @property aliasSuffix A suffix portion of the `android:name` attribute in the manifest.
 * @property iconForegroundId The foreground drawable resource used in icon previews.
 * @property iconBackground The background layer used in icon previews, which can be a solid color or drawable.
 * @property titleId A string resource describing the icon in the icon picker screen.
 * @property subtitleId An optional string resource used as a secondary label.
 */
enum class AppIcon(
    val aliasSuffix: String,
    @param:DrawableRes val iconForegroundId: Int = R.drawable.ic_wordmark_logo,
    val iconBackground: IconBackground = IconBackground.Color(colorResId = colorsR.color.photonWhite),
    @param:StringRes val titleId: Int,
    @param:StringRes val subtitleId: Int? = null,
) {
    AppDefault(
        aliasSuffix = "App",
        iconBackground = IconBackground.Color(colorResId = R.color.ic_launcher_background),
        titleId = R.string.alternative_app_icon_option_default,
    ),
    ;

    /**
     * [AppIcon] helper object
     */
    companion object {
        /**
         * Returns the [AppIcon] associated with the given string.
         */
        fun fromString(aliasSuffix: String): AppIcon = AppDefault
    }
}

/**
 * Represents the background layer of an app icon mipmap assigned to a `<activity-alias>`.
 */
sealed class IconBackground {
    /**
     * A solid color background.
     */
    data class Color(
        @param:ColorRes val colorResId: Int,
    ) : IconBackground()

    /**
     * A drawable background.
     */
    data class Drawable(
        @param:DrawableRes val drawableResId: Int,
    ) : IconBackground()
}
