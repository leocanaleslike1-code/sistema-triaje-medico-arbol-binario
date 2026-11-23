namespace TriajeBinarioApp.Clases
{
    public class NodoArbol
    {
        public Paciente Datos { get; set; }
        public NodoArbol? Izquierdo { get; set; }
        public NodoArbol? Derecho { get; set; }

        public NodoArbol(Paciente paciente)
        {
            Datos = paciente;
            Izquierdo = null;
            Derecho = null;
        }
    }
}