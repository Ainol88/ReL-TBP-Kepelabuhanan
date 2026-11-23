package id.reltv.tbp
import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
class MainActivity: Activity() {
 override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); val w=WebView(this); w.settings.javaScriptEnabled=true; w.settings.domStorageEnabled=true; w.webViewClient=WebViewClient(); w.webChromeClient=WebChromeClient(); setContentView(w); w.loadUrl("file:///android_asset/index.html") }
}
