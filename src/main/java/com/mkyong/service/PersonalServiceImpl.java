package com.mkyong.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.PersonalDao;
import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;

@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalDao personalDao;

	@Transactional
	public void addPersonal(Personal personal) {
		personalDao.addPersonal(personal);
	}

	public void updatePersonal(Personal personal) {
		personalDao.updatePersonal(personal);
	}

	@Transactional
	public List<Personal> getAllPersonal() {
		List<Personal> list = new ArrayList<Personal>();
		list = personalDao.getAllPersonal();
		return list;
	}

	public List<Personal> getPersonal(Integer id) {

		List<Personal> list = new ArrayList<Personal>();
		list = personalDao.getPersonal(id);
		return list;
	}

	public void addUser(User user) {
		personalDao.addUser(user);
	}

	public void addUserRole(UserRole userRole) {
		personalDao.addUserRole(userRole);

	}

	public void deletePersonal(Integer id) {
		personalDao.deletePersonal(id);
	}

	public void sesionEmail(String emailDestino, String contraseña) {
		final String fromEmail = "intime.uclm.esi@gmail.com"; // requires valid gmail id
		final String password = "admin_1234"; // correct password for gmail id
		final String toEmail = emailDestino; // can be any email id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		sendEmail(session, toEmail, "Contraseña LiceDQTool", "Su contraseña es:" + contraseña);

	}

	public void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@licedqtool.com", "NoReply-LiceDQTool"));

			msg.setReplyTo(InternetAddress.parse("no_reply@licedqtool.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String username) {
		personalDao.deleteUser(username);
	}

	public List<Personal> getPersonalByUsername(String username) {
		List<Personal> list = new ArrayList<Personal>();
		list = personalDao.getPersonalByUsername(username);
		return list;
	}

}
