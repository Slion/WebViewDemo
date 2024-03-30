package net.slions.webviewdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebViewClientCompat
import net.slions.webviewdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    var parent: ViewGroup? = null
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set Title
        title = getString(R.string.app_name)

        // Setup debugging; See https://developers.google.com/web/tools/chrome-devtools/remote-debugging/webviews for reference
        if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        // Enable Javascript
        binding.webview.settings.javaScriptEnabled = true
        //

        binding.webview.webViewClient = object :
            WebViewClientCompat() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false
            }
        }
        // Load the content
        //binding.webview.loadUrl("https://raw.githubusercontent.com/views-widgets-samples/assets/index.html")
        //binding.webview.loadUrl("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_global_spellcheck")
        //binding.webview.loadUrl("https://annuel.framapad.org/p/anything")
        //binding.webview.loadUrl("https://stackoverflow.com")
        binding.webview.loadUrl("https://webglsamples.org/aquarium/aquarium.html")

        //binding.webview.loadUrl("view-source:https://slions.net")
    }

    override fun onPause() {
        super.onPause()
        //parent = binding.webview.removeFromParent()
    }

    override fun onResume() {
        super.onResume()
        // Apparently just removing the WebView and putting it back fixes cursor hover issues
        //parent = binding.webview.removeFromParent()
        //if (binding.webview.parent == null) {
        //    parent?.addView(binding.webview)
        //}

        //binding.webview.requestFocus()
    }

}

