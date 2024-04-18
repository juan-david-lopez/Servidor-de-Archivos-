package src.domain;


    public class Foto extends Contenido {

        // Miembros tipo variable.

        /**
         * Cuerpo o contenido de la foto.
         */
        byte[] cuerpo;


        // Miembros tipo método (Constructor)

        /**
         * Constructor.
         *
         * @param idContenido Identificador único.
         * @param title Título de la foto.
         * @param fechaPublicacion Fecha en que se publicó.
         */
        public Foto(long idContenido, String title, String fechaPublicacion) {
            super(idContenido, title, fechaPublicacion);
        }

        /**
         * Constructor.
         *
         * @param idContenido Identificador único.
         * @param title Título de la foto.
         * @param fechaPublicacion Fecha en que se publicó.
         */
        public Foto(long idContenido, String title, String fechaPublicacion, byte[] cuerpo) {
            super(idContenido, title, fechaPublicacion);
            this.cuerpo = cuerpo;
        }


        // Miembros tipo método (Accesores)

        /**
         * @return the cuerpo
         */
        public byte[] getCuerpo() {
            return cuerpo;
        }

        /**
         * @param cuerpo the cuerpo to set
         */
        public void setCuerpo(byte[] cuerpo) {
            this.cuerpo = cuerpo;
        }
    }

