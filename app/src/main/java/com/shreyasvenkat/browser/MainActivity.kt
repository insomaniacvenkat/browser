package com.shreyasvenkat.browser

import android.app.Activity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var urlEditText: EditText
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        goButton.setOnClickListener {
            val url = urlEditText.text.toString()
            if (url.isNotEmpty()) {
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    webView.loadUrl("http://$url")
                } else {
                    webView.loadUrl(url)
                }
            }
        }
    }
}
