package co.edu.uco.asistenciauco.application.outputport.entity.constants;


public class SendGridConstants {
    public static final String SUBJECT = "[AsisteUCO] - Inasistencia";

    public static final String CONTENTFIRST = "Se registro una inasistencia a su nombre en la materia: ";

    public static final String CONTENTLAST ="en la sesion de la fecha: ";

    public static final String HTMLCONTENT = """
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Asistencia No Registrada</title>
</head>
<body style="margin:0; padding:0; font-family: Arial, sans-serif; background-color: #f4f4f4;">
  <table role="presentation" width="100%%" cellspacing="0" cellpadding="0" border="0" style="background-color: #f4f4f4;">
    <tr>
      <td align="center">
        <table role="presentation" width="600" cellspacing="0" cellpadding="0" border="0" style="background-color: #ffffff; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1);">
          <tr>
            <td align="center" style="background-color: #2e7d32; padding: 20px; border-radius: 6px 6px 0 0;">
              <h1 style="color: #ffffff; margin: 0;">Asistencia No Registrada</h1>
            </td>
          </tr>
          <tr>
            <td style="padding: 20px; color: #333333;">
              <p style="font-size: 16px; font-weight: bold; text-align: justify;">
                %s
              </p>
            </td>
          </tr>
          <tr>
            <td align="center" style="padding: 20px;">
              <a href="https://uco.edu.co/" style="background-color: #2e7d32; color: #ffffff; padding: 12px 24px; text-decoration: none; border-radius: 4px; font-weight: bold;">
                Más información aquí
              </a>
            </td>
          </tr>
          <tr>
            <td style="padding-top: 30px; font-size: 12px; color: #999999; text-align: center;">
              Universidad Católica de Oriente · ©2025
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>
""";
    private SendGridConstants() {}
}
