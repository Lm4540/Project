package Clases;
import java.util.*;
import javax.mail.*;
import javax.swing.*;
import javax.mail.internet.*;

/**
 *
 * @author Luis Rivera
 */
public class Email {

    // destinatario1@hotmail.com,destinatario2@hotmail.com, destinatario_n@hotmail.com
    private InternetAddress[] addressTo;
    private String MessageMail;//contenido del mensaje

    public Email(){}

    public Email(String Contraseña) {
         this.MessageMail = "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>"+Contraseña+"</title>\n" +
"	<style type=\"text/css\">\n" +
"	    html {\n" +
"        height:80%;\n" +
"        width:80%;}\n" +
"		.img2{\n" +
"		height: 100px;\n" +
"		width: 100px;\n" +
"		background-repeat: no-repeat;\n" +
"		background-position: 50%;\n" +
"		border-radius: 50%;\n" +
"		background-size: 100% auto;}\n" +
"		body{\n" +
"        background:#8ba987 url('http://www.fondosblackberry.com/user-content/uploads/wall/o/53/Surface_I_Wallpaper_by_sword1ne.jpg')\n" +
"        no-repeat center center;\n" +
"        bgcolor: aqua;\n" +
"        background-size:100% 100%;\n" +
"        width:100%;\n" +
"        height: 100%;}\n" +
"	    h1{\n" +
"    	color: white;\n" +
"		font-family: verdana;\n" +
"		font-size: 40px;\n" +
"		text-align: center;\n" +
"		text-decoration: underline; }\n" +
"        h3{\n" +
"    	color: white;\n" +
"		font-family: verdana;\n" +
"		font-size: 20px;\n" +
"		text-align: center;\n" +
"		text-decoration: underline; }\n" +
"		table{\n" +
"		color: white;\n" +
"		font-family:cooper black;\n" +
"		font-size:30px;\n" +
"		text-align: center;\n" +
"		border-spacing: 20px;}\n" +
"		fieldset{\n" +
"		color: white;\n" +
"		font-family:Verdana;\n" +
"		font-size:20px;\n" +
"		text-align: center;\n" +
"		border-spacing: 20px;\n" +
"		bottom: 5%;\n" +
"		right: 5%;}\n" +
"	</style>\n" +
"}\n" +
"</head>\n" +
"<body >\n" +
"\n" +
"<div align=\"center\">\n" +
"<h1 >Agenda Personal</h1>\n" +
"\n" +
"\n" +
"   <h3>Equipo de desarrollo de Software</h3>\n" +
"   <img src=\"http://slashware.co/img/services/softwareDevelopment.png\">\n" +
"</div>\n" +
"<table border=\"5\" align=\"center\">\n" +
"<tr><td><div id=\"lube\"><img src=\"http://mediacionandalucia.es/wp-content/uploads/2015/07/im5.png\" class=\"img2\"><div><text id=\"boton\" type=\"text\"> Cambiar contraseña</text></td>\n" +
"	\n" +
"\n" +
"<td><div id=\"lube\"><img src=\"https://www.aulatutorial.com/Content/images/foto-no-disponible.jpg\" class=\"img2\"><div><text id=\"boton\" type=\"text\"> Informacion</text></td>\n" +
"\n" +
"<td><div id=\"lube\"><img src=\"http://www.minegocioinmobiliario.com/imgs/plantillas/software-inmobiliario-de-gestion-remota-20160212174940.jpg\" class=\"img2\"><div><text id=\"boton\" type=\"text\">Utilizar Software</text></td>\n" +
"</table>\n" +
"<fieldset>\n" +
"		<legend style=\"font-family:verdana\">Informacion</legend>\n" +
"el equipo de desarrollo se encuentra aprendiendo, asi que si su software no funciona, reclamele al maestro porque no les enseño bien, y si les funciona, es debido al arduo trabajo y dedicacion de sus estudiantes		\n" +
"\n" +
"	</fieldset>\n" +
"\n" +
"</div>\n" +
"</body>\n" +
"</html>";
         
    }

    public void SEND()
    {
        try {
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
            //
            SMTPAuthenticator auth = new SMTPAuthenticator( "0agendapersonal@gmail.com", "Itca123!" );
            Session session = Session.getDefaultInstance(props, auth);
            session.setDebug(false);
            //Se crea destino y origen del mensaje
            MimeMessage mimemessage = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress( "0agendapersonal@gmail.com");
            mimemessage.setFrom(addressFrom);
            mimemessage.setRecipients(Message.RecipientType.TO, addressTo);
            mimemessage.setSubject( "Agenda Personal: Tu nueva Contraseña" );
            // Se crea el contenido del mensaje
            MimeBodyPart mimebodypart = new MimeBodyPart();
            mimebodypart.setText( MessageMail );
            mimebodypart.setContent( MessageMail , "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimebodypart);            
            mimemessage.setContent(multipart);            
            mimemessage.setSentDate(new Date());
            Transport.send(mimemessage);
            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (MessagingException ex) {
            System.out.println(ex);
        }

    }
    //destinatarios
    public void setTo(String mails){
        String[] tmp =mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
    }
    public InternetAddress[] getTo(){ return this.addressTo; }
    //titulo correo
    

}
