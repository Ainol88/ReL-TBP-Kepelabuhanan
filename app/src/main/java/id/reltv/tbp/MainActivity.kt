package id.reltv.tbp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.print.PrintManager
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.addJavascriptInterface(PrintBridge(this, webView), "AndroidPrint")
        setContentView(webView)
        webView.loadUrl("file:///android_asset/index.html")
    }

    private class PrintBridge(
        private val activity: Activity,
        private val webView: WebView
    ) {
        @JavascriptInterface
        fun printPage() {
            activity.runOnUiThread {
                val printManager = activity.getSystemService(Context.PRINT_SERVICE) as PrintManager
                val adapter = webView.createPrintDocumentAdapter("ReL-TBP-Kepelabuhanan")
                printManager.print("TBP Kepelabuhanan", adapter, null)
            }
        }
    }
}
