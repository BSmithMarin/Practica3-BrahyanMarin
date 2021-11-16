package com.example.practica3_brahyan_marin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practica3_brahyan_marin.R;


public class AreasVolumenes extends Fragment implements View.OnClickListener{

    //Definicion de los elementos visuales
    private EditText etnRadioEsfera;
    private EditText etnLadoCubo;
    private EditText etnAnchoParalelepipedo;
    private EditText etnAltoParalelepipedo;
    private EditText etnLargoParalelepipedo;

    private Button btnAreaEsfera;
    private Button btnVolumenEsfera;
    private Button btnAreaCubo;
    private Button btnVolumenCubo;
    private Button btnAreaParalelepipedo;
    private Button btnVolumenParalelepipedo;

    private TextView tvResultadoEsfera;
    private TextView tvResultadoCubo;
    private TextView tvResultadoParalelepipedo;

    public AreasVolumenes() { // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_areas_volumenes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Anclaje a codigo de elementos visuales
        //Campos editables
        etnRadioEsfera = getView().findViewById(R.id.etnRadioEsfera);
        etnLadoCubo = getView().findViewById(R.id.etnLadoCubo);
        etnAltoParalelepipedo = getView().findViewById(R.id.etnAltoParalelepipedo);
        etnAnchoParalelepipedo = getView().findViewById(R.id.etnAnchoParalelepipedo);
        etnLargoParalelepipedo = getView().findViewById(R.id.etnLargoParalelepipedo);
        //Botones
        btnAreaEsfera = getView().findViewById(R.id.btnAreaEsfera);
        btnVolumenEsfera = getView().findViewById(R.id.btnVolumenEsfera);
        btnAreaCubo = getView().findViewById(R.id.btnAreaCubo);
        btnVolumenCubo = getView().findViewById(R.id.btnVolumenCubo);
        btnAreaParalelepipedo = getView().findViewById(R.id.btnAreaParalelepipedo);
        btnVolumenParalelepipedo = getView().findViewById(R.id.btnVolumenParalelepipedo);
        //Text views de los resultados
        tvResultadoEsfera = getView().findViewById(R.id.tvResultadoEsfera);
        tvResultadoCubo = getView().findViewById(R.id.tvResultadoCubo);
        tvResultadoParalelepipedo = getView().findViewById(R.id.tvResultadoParalelepipedo);

        //Se establece esta clase como listener de los botones
        btnAreaEsfera.setOnClickListener(this);
        btnVolumenEsfera.setOnClickListener(this);
        btnAreaCubo.setOnClickListener(this);
        btnVolumenCubo.setOnClickListener(this);
        btnAreaParalelepipedo.setOnClickListener(this);
        btnVolumenParalelepipedo.setOnClickListener(this);
    }

    @Override
    public void onClick(View click) {

        if ( click == btnAreaEsfera ){

        }else if( click == btnVolumenEsfera ){

        }else if( click == btnAreaCubo ){

        }else if( click == btnVolumenCubo ){

        }else if( click == btnAreaParalelepipedo ){

        }else if( click == btnVolumenParalelepipedo ){

        }
    }
}