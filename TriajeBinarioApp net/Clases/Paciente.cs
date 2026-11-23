namespace TriajeBinarioApp.Clases
{
    public class Paciente
    {
        public string Nombre { get; set; }
        public string Cedula { get; set; }
        public string Sintoma { get; set; }
        public int PuntajeRiesgo { get; set; } // Criterio de ordenamiento (1 - 100)

        public Paciente(string nombre, string cedula, string sintoma, int puntajeRiesgo)
        {
            Nombre = nombre;
            Cedula = cedula;
            Sintoma = sintoma;
            PuntajeRiesgo = puntajeRiesgo;
        }

        public override string ToString()
        {
            return $"[Riesgo: {PuntajeRiesgo}] {Nombre} (CC: {Cedula}) - Síntoma: {Sintoma}";
        }
    }
}