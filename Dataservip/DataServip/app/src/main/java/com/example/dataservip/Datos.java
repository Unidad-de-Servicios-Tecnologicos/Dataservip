package com.example.dataservip;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dataservip.modelos.Conductor;
import com.example.dataservip.modelos.Vehiculo;
import com.squareup.picasso.Picasso;

import java.util.List;

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

        // Obtener el vehículo desde el Intent
        Vehiculo vehiculo = getIntent().getParcelableExtra("vehiculo");

        if (vehiculo == null) {
            Toast.makeText(Datos.this, "No se recibieron datos del vehículo", Toast.LENGTH_SHORT).show();
            return;
        }

        placaTextView.setText(vehiculo.getPlaca());

        internoTextView.setText(vehiculo.getInterno());

        empresaTextView.setText(vehiculo.getRazonSocialEmpresa());

        direccionTextView.setText(vehiculo.getDireccionEmpresa());

        telefonoTextView.setText(vehiculo.getTelefonoEmpresa());

        estadoTextView.setText(vehiculo.getEstado());

        List<Conductor> conductores = vehiculo.getConductores();

        if (conductores == null || conductores.isEmpty()) {
            Toast.makeText(Datos.this, "No hay conductores asociados", Toast.LENGTH_SHORT).show();
            return;
        }

        Conductor primerConductor = conductores.get(0);
        if (primerConductor == null) {
            Toast.makeText(Datos.this, "No se encontró información del primer conductor", Toast.LENGTH_SHORT).show();
            return;

        } else {
            Toast.makeText(this, "Conductor no Valido", Toast.LENGTH_SHORT).show();
        }

        cargarImagenDesdeUrl(primerConductor.getFoto(), conductorImageView);
        nombreConductorTextView.setText(primerConductor.getNombre());
        licenciaTextView.setText(primerConductor.getCategoriaLicencia());
        vigenciaTextView.setText(primerConductor.getVencimientoLicencia());
        pensionesTextView.setText(primerConductor.getPensiones());
        grupoSanguineoTextView.setText(primerConductor.getGrupoSanguineo());
        epsTextView.setText(primerConductor.getEps());
        arlTextView.setText(primerConductor.getArl());

    }
    private void cargarImagenDesdeUrl(String url, ImageView imageView) {
        Picasso.get().load(url).into(imageView);
    }

}
