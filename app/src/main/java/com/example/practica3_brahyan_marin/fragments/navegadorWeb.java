package com.example.practica3_brahyan_marin.fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.practica3_brahyan_marin.R;

public class navegadorWeb extends Fragment {

    //Definicion del WebView
    WebView browser;
    //Constante que almacena la URL de la pagina que se mostrara siempre al princio
    private final String BASE_URL = "https://www.universoformulas.com/matematicas/geometria/";

    public navegadorWeb() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navegador_web, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        browser= (WebView) getView().findViewById(R.id.WebView);

        //Definimos el webChromeClient del WebView
        browser.setWebChromeClient( new WebChromeClient() );
        //Definimos webViewClient del WebView
        browser.setWebViewClient( new WebViewClient() );
        //Permitimos que el WebView ejecute codigo JavaScript de las Webs
        browser.getSettings().setJavaScriptEnabled(true);
        //Permitimos que se pueda hacer zoom con gestos y ocultamos los botones de zoom
        browser.getSettings().setBuiltInZoomControls(true);
        browser.getSettings().setDisplayZoomControls(false);
        // Cargamos la web
        browser.loadUrl(BASE_URL);
        // Callback ha realizar cuando pulsamos el boton de atras
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //Esta funcion gestiona la accion a realizar si se pulsa el boton de atras
                //Si hay una web anterior se vuelve a ella, sino realizamos la funcion por defecto
                //del boton volver, en este caso cerrar la aplicacion y volver al escritorio
                if ( browser.canGoBack() ){
                    browser.goBack();
                }else{
                    requireActivity().onBackPressed();
                }
            }
        };
        //Seteamos el callback anterior como accion a realizar si se pulsa el boton volver
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
    }


}