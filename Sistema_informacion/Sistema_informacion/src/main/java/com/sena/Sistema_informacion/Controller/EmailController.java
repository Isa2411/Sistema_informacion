package com.sena.Sistema_informacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class EmailController {

	@Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/enviar-correo-registro")
    public String enviarCorreoRegistro() {
       try{
            String destinatario="isabelacordobaguti@gmail.com";
            String asunto="¡Bienvenid@ a nuestro sistema de información";
            String cuerpo=""
            + "    <p>Nos complace darte la bienvenida a nuestro sistema de información, la plataforma ideal para crear registros de usuarios con su informacin personal.</p>";
        
            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                    return "No se pudo envíar";
            }

        }catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar "+e.getMessage();
        }
    }

    public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}
	
}
