<?php 
include 'conexion.php';

// Obtener el término de búsqueda
$termino_busqueda = $_POST['busqueda'];

// Consulta SQL para buscar en la base de datos
$consulta = "SELECT * FROM vehiculos WHERE PLACA LIKE '%$termino_busqueda%' OR correo LIKE '%$termino_busqueda%'";
$resultado = $conexion->query($consulta);

// Mostrar resultados
echo "<h2>Resultados de la búsqueda</h2>";
while ($fila = $resultado->fetch_assoc()) {
    echo "ID: " . $fila['id'] . "<br>";
    echo "Nombre: " . $fila['nombre'] . "<br>";
    echo "Correo: " . $fila['correo'] . "<br>";
    echo "-------------------------<br>";
}

// Cerrar la conexión
$conexion->close();
?>