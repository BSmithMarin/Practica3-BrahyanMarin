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
import android.widget.Toast;

import com.example.practica3_brahyan_marin.R;


public class AreasVolumenes extends Fragment implements View.OnClickListener{

    //Definicion de los elementos visuales
    //Campos editables
    private EditText etnRadioEsfera;
    private EditText etnLadoCubo;
    private EditText etnAnchoParalelepipedo;
    private EditText etnAltoParalelepipedo;
    private EditText etnLargoParalelepipedo;
    //Botones
    private Button btnAreaEsfera;
    private Button btnVolumenEsfera;
    private Button btnAreaCubo;
    private Button btnVolumenCubo;
    private Button btnAreaParalelepipedo;
    private Button btnVolumenParalelepipedo;
    //Text views de los resultados
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
        //Guardara el resultado de las operaciones si se introducen los datos correctamente
        double resultado = 0.0;

        if ( click == btnAreaEsfera || click == btnVolumenEsfera){  //***ESFERA***
            try {
                //Se obtine valor del radio de la esfera introducido por el usuario
                double radioEsfera = Double.parseDouble( etnRadioEsfera.getText().toString() );
                //Si el radio es 0 se lanza nueva excepcion
                if ( radioEsfera == 0 ){
                    throw new Exception("El radio es 0");
                }
                //En funcion del boton pulsado se calcula el are o volumen de la esfera
                if( click == btnAreaEsfera){
                    //Se calcula el area de la esfera, formula: 4*PI*R^2
                    resultado = 4*Math.PI*Math.pow(radioEsfera,2);
                }else if( click == btnVolumenEsfera ){
                    //Calculo de volumen, formula: (4/3)*pi*R^3
                    resultado = (4.0/3.0)*Math.PI*Math.pow(radioEsfera,3);
                }

                //Si no han saltado excepciones, se muestra el resultado el textViev con 3 decimales
                //de precision
                tvResultadoEsfera.setText( String.format( "%,.3f", resultado) );
            }catch (Exception e){
                //Se borra el resultado anterior si lo hubiese para que no induzca a error
                tvResultadoEsfera.setText("");
                toastPersonalizado("El radio de la esfera debe ser un número mayor que 0");
            }

        }else if( click == btnAreaCubo || click == btnVolumenCubo ){ //***CUBO***
            try {
                //Se obtine valor del lado del cubo introducido por el usuario
                double ladoCubo = Double.parseDouble( etnLadoCubo.getText().toString() );
                //Si el lado es 0 se lanza nueva excepcion
                if ( ladoCubo == 0 ){
                    throw new Exception("El lado es 0");
                }
                //En funcion del boton pulsado se calcula el are o volumen del cubo
                if ( click == btnAreaCubo ){
                    //Calculo de area del cubo, formula: 6*lado^2
                    resultado = 6*Math.pow(ladoCubo,2);
                }else if( click == btnVolumenCubo ){
                    //Calculo de volumen del cubo, formula: lado^3
                    resultado = Math.pow(ladoCubo,3);
                }

                //Se muestra el resultado con 3 decimales de precision
                tvResultadoCubo.setText( String.format( "%,.3f", resultado) );
            }catch (Exception e){
                //Se borra el resultado anterior si lo hubiese para que no induzca a error
                tvResultadoCubo.setText("");
                toastPersonalizado("El lado del cubo debe ser un número mayor que 0");
            }

        }else if( click == btnAreaParalelepipedo || click == btnVolumenParalelepipedo ){
            try{
                //Se obtine valor de las medidas del paralelepipedo
                double anchoParalelepipedo = Double.parseDouble( etnAnchoParalelepipedo.getText().toString() );
                double largoParalelepipedo = Double.parseDouble( etnLargoParalelepipedo.getText().toString() );
                double altoParalelepipedo = Double.parseDouble( etnAltoParalelepipedo.getText().toString() );
                //Si alguna de las medidas es 0 se lanza excepcion
                if ( anchoParalelepipedo == 0 || largoParalelepipedo == 0 || altoParalelepipedo == 0){
                    throw new Exception("Alguna de las medidas es 0");
                }
                if( click == btnAreaParalelepipedo ){
                    //Calculo del area, formula: 2*(A*B+A*C+B*C)
                    resultado = 2*(anchoParalelepipedo*largoParalelepipedo +
                            anchoParalelepipedo*altoParalelepipedo + largoParalelepipedo*altoParalelepipedo);
                }else if( click == btnVolumenParalelepipedo ){
                    //Calculo del area del paralelepipedo, formula: Alto*Ancho*Largo
                    resultado = anchoParalelepipedo * largoParalelepipedo * altoParalelepipedo;
                }

                //Se muestra el resultado con 3 decimales de precision
                tvResultadoParalelepipedo.setText( String.format( "%,.3f", resultado) );
            }catch (Exception e){
                //Se borra el resultado anterior si lo hubiese para que no induzca a error
                tvResultadoParalelepipedo.setText("");
                toastPersonalizado("Todas las medidas del paralelepipedo deben ser numeros mayores que 0");
            }
        }
    }

    public void toastPersonalizado (String mensaje){
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}