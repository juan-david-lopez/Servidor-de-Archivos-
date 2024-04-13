package src.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representa una persona natural y sus atributos
 * básicos.
 */
public class Persona {

        // Miembros tipo variable.

        /**
         * Identificador único.
         */
        protected long idPersona;

        /**
         * El documento nacional de identidad.
         */
        protected String documento;

        /**
         * Los emails conocidos de la persona.
         */
        protected ArrayList<String> emails;

        /**
         * El nombre completo de la persona.
         */
        protected String nombreCompleto;

        /**
         * Los teléfonos conocidos de la persona.
         */
        protected String[] telefonos;

        /**
         * El tipo de documento de identidad.
         */
        protected String tipoDocumento;


        // Miembros tipo método (Constructor)

        /**
         * Constructor.
         *
         * @param idPersona Identificador único.
         * @param documento Documento de identidad nacional.
         * @param emails Correos conocidos de la persona.
         * @param nombreCompleto Nombre de la persona.
         * @param telefonos Teléfonos conocidos de la persona.
         * @param tipoDocumento Tipo de documento.
         */
        public Persona(long idPersona, String documento, ArrayList<String> emails, String nombreCompleto,
                       String[] telefonos, String tipoDocumento) {
            super();
            this.idPersona = idPersona;
            this.documento = documento;
            this.emails = emails;
            this.nombreCompleto = nombreCompleto;
            this.telefonos = telefonos;
            this.tipoDocumento = tipoDocumento;
        }

        /**
         * Constructor.
         *
         * @param idPersona Identificador único.
         * @param documento Documento de identidad nacional.
         * @param nombreCompleto Nombre de la persona.
         */
        public Persona(long idPersona, String documento, String nombreCompleto) {
            super();
            this.idPersona = idPersona;
            this.documento = documento;
            this.nombreCompleto = nombreCompleto;
        }

        /**
         * Constructor.
         *
         * @param documento Documento de identidad nacional.
         * @param nombreCompleto Nombre de la persona.
         */
        public Persona(String documento, String nombreCompleto) {
            super();
            this.documento = documento;
            this.nombreCompleto = nombreCompleto;
        }


        // Miembros tipo método (Accesores)

        /**
         * @return the idPersona
         */
        public long getIdPersona() {
            return idPersona;
        }

        /**
         * @param idPersona the idPersona to set
         */
        public void setIdPersona(long idPersona) {
            this.idPersona = idPersona;
        }

        /**
         * @return the documento
         */
        public String getDocumento() {
            return documento;
        }

        /**
         * @param documento the documento to set
         */
        public void setDocumento(String documento) {
            this.documento = documento;
        }

        /**
         * @return the emails
         */
        public ArrayList<String> getEmails() {
            return emails;
        }

        /**
         * @param emails the emails to set
         */
        public void setEmails(ArrayList<String> emails) {
            this.emails = emails;
        }

        /**
         * @return the nombreCompleto
         */
        public String getNombreCompleto() {
            return nombreCompleto;
        }

        /**
         * @param nombreCompleto the nombreCompleto to set
         */
        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }

        /**
         * @return the telefonos
         */
        public String[] getTelefonos() {
            return telefonos;
        }

        /**
         * @param telefonos the telefonos to set
         */
        public void setTelefonos(String[] telefonos) {
            this.telefonos = telefonos;
        }

        /**
         * @return the tipoDocumento
         */
        public String getTipoDocumento() {
            return tipoDocumento;
        }

        /**
         * @param tipoDocumento the tipoDocumento to set
         */
        public void setTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }


        // Miembros tipo método (hashcode e equals)

        @Override
        public int hashCode() {
            return Objects.hash(documento);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Persona other = (Persona) obj;
            return Objects.equals(documento, other.documento);
        }
    }
