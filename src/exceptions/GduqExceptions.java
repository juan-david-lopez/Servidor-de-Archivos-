package src.exceptions;

import javax.swing.*;

public class GduqExceptions extends Exception {

        // Miembros tipo variable.

        /**
         * Atributo utilizado para serializar el objeto.
         */
        private static final long serialVersionUID = 1L;

        public GduqExceptions() {
            super();
        }

        public GduqExceptions(String message) {
            super(message);
        }

        public GduqExceptions(String message, Exception excep) {
            super(message, excep);
        }

        // Miembros tipo clase

        public class PublicadorDuplicadoException extends GduqExceptions {

            private static final long serialVersionUID = 1L;
            private String sistemaDePersistencia; 	// BD o CSV.
            private String nombreDelPublicador;		// Nombre que se intento guardar.

            public PublicadorDuplicadoException() {
                super("el usuario ingresado ya esta en uso"); // TODO Gestionar un proveedor de mensajes.
                JOptionPane.showMessageDialog(null, "se necesita un publicador unico, el usuario ingresado existe \n" +
                        "o ya esta en uso");
            }

            public PublicadorDuplicadoException(
                    String sistemaDePersistencia, String nombreDelPublicador) {
                super("el publicador no se puede encontrar duplicado");
                this.sistemaDePersistencia = sistemaDePersistencia;
                this.nombreDelPublicador = nombreDelPublicador;
            }

            public String getSistemaDePersistencia() {
                return sistemaDePersistencia;
            }

            public void setSistemaDePersistencia(String sistemaDePersistencia) {
                this.sistemaDePersistencia = sistemaDePersistencia;
            }

            public String getNombreDelPublicador() {
                return nombreDelPublicador;
            }

            public void setNombreDelPublicador(String nombreDelPublicador) {
                this.nombreDelPublicador = nombreDelPublicador;
            }

            @Override
            public String getMessage() {
                return "el publicador no se puede encontrar duplicado"; // TODO Gestionar un proveedor de mensajes.
            }

            @Override
            public String toString() {
                return "PublicadorDuplicadoException [sistemaDePersistencia=" + sistemaDePersistencia
                        + ", nombreDelPublicador=" + nombreDelPublicador + "]";
            }
        }

        public class CsvDePublicadorMalFormado extends GduqExceptions {

            private static final long serialVersionUID = 1L;



            private String sistemaDePersistencia; 	// CSV.
            private String nombreDelPublicador;
            public CsvDePublicadorMalFormado() {

            }
            public CsvDePublicadorMalFormado(String sistemaDePersistencia, String nombreDelPublicador){
                super(" no se pudo crear debido a que no cumple con los requisitos demandados");
                this.nombreDelPublicador=nombreDelPublicador;
                this.sistemaDePersistencia=sistemaDePersistencia;
            }
            @Override
            public String toString(){
                return "PublicadorDuplicadoException [sistemaDePersistencia=" + sistemaDePersistencia
                        + ", nombreDelPublicador=" + nombreDelPublicador + "]";
            }
            public String getSistemaDePersistencia() {
                return sistemaDePersistencia;
            }
            public String getNombreDelPublicador() {
                return nombreDelPublicador;
            }

        }


    }
