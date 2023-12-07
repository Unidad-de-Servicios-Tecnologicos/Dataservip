package com.example.dataservip;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dataservip.modelos.Conductor;
import com.example.dataservip.modelos.Vehiculo;
import com.squareup.picasso.Picasso;

public class Datos extends AppCompatActivity {

    private TextView placaTextView;
    private TextView internoTextView;
    private TextView empresaTextView;
    private TextView direccionTextView;
    private TextView telefonoTextView;
    private TextView estadoTextView;
    private ImageView conductorImageView;
    private TextView nombreConductorTextView;
    private TextView licenciaTextView;
    private TextView vigenciaTextView;
    private TextView pensionesTextView;
    private TextView grupoSanguineoTextView;
    private TextView epsTextView;
    private TextView arlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        // Inicializar vistas (asegúrate de que los IDs coincidan)
        placaTextView = findViewById(R.id.placa);
        internoTextView = findViewById(R.id.interno);
        empresaTextView = findViewById(R.id.razon_social_empresa);
        direccionTextView = findViewById(R.id.direccion_empresa);
        telefonoTextView = findViewById(R.id.telefono_empresa);
        estadoTextView = findViewById(R.id.estado);
        conductorImageView = findViewById(R.id.imageView4);
        nombreConductorTextView = findViewById(R.id.nombreConductor);
        licenciaTextView = findViewById(R.id.licencia);
        vigenciaTextView = findViewById(R.id.vigencia);
        pensionesTextView = findViewById(R.id.Pensiones);
        grupoSanguineoTextView = findViewById(R.id.grupoSanguineo);
        epsTextView = findViewById(R.id.Eps);
        arlTextView = findViewById(R.id.Arl);

        // Aquí debes añadir la lógica para obtener y mostrar los datos del vehículo y conductor
        obtenerDatosDeLaApi();
    }

    private void obtenerDatosDeLaApi() {
        // Supongamos que tienes una clase ApiClient que maneja las solicitudes
        consulta.ApiClient apiClient = new consulta.ApiClient();

        // Hacer la solicitud a la API (esto es solo un ejemplo, ajusta según tus necesidades)
        apiClient.obtenerDatos(new ApiCallback<Vehiculo>() {
            @Override
            public void onSuccess(Vehiculo vehiculo) {
                // Llenar los TextView e ImageView con los datos del vehículo y conductor
                placaTextView.setText(vehiculo.getPlaca());
                internoTextView.setText(vehiculo.getInterno());
                empresaTextView.setText(vehiculo.getRazonSocialEmpresa());
                direccionTextView.setText(vehiculo.getDireccionEmpresa());
                telefonoTextView.setText(vehiculo.getTelefonoEmpresa());
                estadoTextView.setText(vehiculo.getEstado());

                // Mostrar la imagen del conductor con Picasso
                cargarImagenDesdeUrl(vehiculo.getConductores().get(0).getFoto(), conductorImageView);

                // Llenar los datos del conductor
                Conductor conductor = vehiculo.getConductores().get(0);
                nombreConductorTextView.setText(conductor.getNombre());
                licenciaTextView.setText(conductor.getCategoriaLicencia());
                vigenciaTextView.setText(conductor.getVencimientoLicencia());
                pensionesTextView.setText(conductor.getPensiones());
                grupoSanguineoTextView.setText(conductor.getGrupoSanguineo());
                epsTextView.setText(conductor.getEps());
                arlTextView.setText(conductor.getArl());
            }

            @Override
            public void onFailure(String mensajeError) {
                // Manejar el error, mostrar un mensaje al usuario, etc.
                Toast.makeText(Datos.this, "Error al obtener datos: " + mensajeError, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para cargar una imagen desde una URL a un ImageView (debes implementar según tu caso)
    private void cargarImagenDesdeUrl(String url, ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }
}
