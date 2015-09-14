-- phpMyAdmin SQL Dump
-- version 3.5.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 03, 2013 at 07:23 PM
-- Server version: 5.5.32-0ubuntu0.13.04.1
-- PHP Version: 5.4.9-4ubuntu2.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mando_medio`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE IF NOT EXISTS `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `title` varchar(200) NOT NULL,
  `text` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `date`, `title`, `text`) VALUES
(1, '2013-04-15', 'Nueva Gerente de Negocios y Operaciones en Mandomedio', '\n			<p class="date">Santiago, 15 de abril de 2013.-</p>\n			<p>\n				<b>María Soledad Mosquera Rojas</b> asumió como nueva Gerente de Negocios y Operaciones de la consultora Mandomedio,\n				especializada en Búsqueda y Evaluación, Coaching y Outplacement profesionales de cargos medios que tiene sede en Chile\n				y oficinas  en Argentina, Perú y Colombia.\n			</p>\n			<p>	\n				María Soledad Mosquera es psicóloga de la Pontificia Universidad Católica de Chile con postgrado en Dirección de \n				Recursos Humanos en la misma universidad. Posee más de 10 años de experiencia en el área de Recursos Humanos, y \n				anteriormente formó parte del grupo Santander y MetLife Chile, siendo responsable de la selección para distintos\n				niveles de cargo y de la elaboración de proyectos de desarrollo organizacional. Se unió a Mandomedio hace tres años,\n				donde su expertise la llevó al puesto de Consultora Senior.\n			</p>\n			<p>		\n				Desde sus actuales funciones, ella canaliza las inquietudes y requerimientos de los clientes de la firma y supervisa\n				la gestión del equipo de consultores y de researchers.\n				\n			</p>\n			<div class="imagecaption">\n				<img  src="{base-url}/resources/img/blog/soledadmosquera.png" />\n				<div>María Soledad Mosquera Rojas</div>\n			</div>\n'),
(2, '2013-07-08', 'Nuevo Director de Desarrollo Internacional en Mandomedio S.A', '\n			<p class="date">Santiago, 8 julio de 2013.-</p>\n			<p>\n				<b>Andrés Gómez López</b> asumió como Director de Desarrollo Internacional de Mandomedio S.A. \n				empresa multilatina especializada en búsqueda, evaluación, coaching y outplacement de \n				profesionales de cargos medios. La consultora tiene sede en Chile y presencia en Perú y \n				Colombia.\n			</p>\n			<p>\n				Andrés Gómez es Ingeniero Comercial con mención en Administración de Empresas de la Pontificia\n				Universidad Católica de Chile. Anteriormente se desempeñó como Gerente General de PayRoll \n				Argentina y luego como Presidente de la misma compañía.\n			</p>\n			<p>\n				En Mandomedio estará encargado de la expansión sudamericana de la empresa y está a cargo de \n				las operaciones en Perú y Colombia, velando por su excelencia y consolidación, además de nuevos\n				negocios internacionales.\n			</p>\n			<div class="imagecaption">\n				<img src="{base-url}/resources/img/blog/andresgomez.png"/>\n				<div>Andrés Gómez López</div></div>\n			\n	'),
(3, '2013-05-07', 'La personalidad del líder define el éxito de la empresa', '			<p class="date">Santiago, 7 de mayo de 2013.-</p>\n			<h3>\n				El especialista Robert Hogan estuvo en nuestro país, patrocinado por Mandomedio, dictando \n				la conferencia "Sistemas de Selección del Talento de Clase Mundial" donde presentó los \n				resultados de sus últimas investigaciones acerca de "Personalidad, Liderazgo y Efectividad \n				Organizacional".\n			</h3>\n			<p>\n				Hoy la personalidad es un atributo que define el tipo de liderazgo de los ejecutivos, si será \n				efectivo o no. Según Robert Hogan, Phd en psicología estadounidense, con más de 30 años de \n				experiencia entregando innovadoras soluciones de assessment y consultoría avanzada en las \n				principales compañías del mundo, plantea que “la personalidad predice el liderazgo, el \n				liderazgo anuncia el desempeño del equipo de trabajo y la compañía, y por ende, la personalidad\n				importa mucho en el trabajo, porque sólo el 20% de las personas es responsable del 80% de la\n				productividad”.\n			</p>\n			<p>\n				Hogan Assessment es un método creado por Robert Hogan, y consiste en un test online que mide \n				la personalidad de las personas que está probado científicamente. Esta medición es utilizada \n				para la selección de personas hasta el desarrollo de altos ejecutivos. Actualmente Mandomedio, \n				empresa multilatina encargada de la búsqueda, evaluación y gestión de talentos, es la única en \n				Chile en ofrecer el método Hogan en sus procesos de selección.\n			</p>\n			<p>\n				"Con el test de personalidad de Hogan, podemos brindar una mayor calidad en la búsqueda y \n				evaluación de ejecutivos, debido a que nos permite una mejor adecuación de los candidatos al \n				perfil del cargo y cultura de la empresa, además, reduce el tiempo de duración de los procesos \n				de selección. Adicionalmente, esta herramienta permite tener una medición estándar en tiempo \n				real de talentos en cualquier parte de América latina, cada vez más requerido por nuestros \n				clientes que provienen de empresas multilatinas", menciona Ignacio González, gerente general \n				de Mandomedio.\n			</p>\n			<h3>Líderes incompetentes</h3>\n			<p>\n				Actualmente, según las investigaciones de Hogan, entre el 50% y 70% de los directivos son \n				incompetentes y malos gerentes, porque no motivan ni despiertan compromiso entre sus colaboradores. \n				Y está comprobado que la personalidad de los gerentes influye directamente en el engagement de los\n				trabajadores, por lo que un buen líder generará mayor compromiso en su equipo de trabajo, lo que \n				se traduce en mayor efectividad, por lo tanto, los resultados de negocio serán positivos.\n			</p>\n			<p>\n				Hoy la selección de ejecutivos requiere ciencia para determinar la personalidad de manera \n				exacta porque esta es predecible y la rentabilidad de una organización depende de la \n				personalidad de sus altos ejecutivos. El método Hogan es utilizado en 40 países alrededor \n				del mundo, se ha aplicado a 3,5 millones de trabajadores, los evaluados han asumido 450 \n				puestos de trabajo diferentes y se han generado 800 estudios de validez del sistema.	\n			</p>\n			<div class="imagecaption">\n				<img th:src="@{resources/img/blog/mmhogan1.png}"/>\n				<div>\n				De Mandomedio: Sandra Fritz, Jefe de Psicólogos, Ana María Castro, Gerente de Comunicaciones;\n				Dr. Tomás Chamorro-Premuzic, Vicepresidente de Innovación de Hogan Assesstments Systems; \n				Dr Robert Hogan; de Mandomedio, Ignacio González, Gerente General; María Soledad Mosquera, \n				Gerente de Negocios, y Rodrigo Correa, Gerente de Consulting.\n				</div>\n			</div>			\n			<div class="imagecaption">\n				<img src="@{/resources/img/blog/mmhogan2.png}"/>\n				<div>\n				Con tema sobre felicidad de las personas\n				</div>\n			</div>	'),
(4, '2013-06-12', 'Mandomedio da el vamos a Club de Líderes de RRHH', '\n			<p class="date">Santiago, 12 de junio de 2013.-</p>\n			<h3>\n				Con la presencia de gerentes de Recursos Humanos de importantes empresas del país, partió\n				el primer encuentro del Club de Líderes de RRHH,  creado por la consultora Mandomedio para\n				generar una instancia de reflexión sobre temas relacionados con  la gestión del talento \n				de las organizaciones.\n			</h3>\n			<p>\n				En su primer encuentro, el Club de Líderes de RRHH abordó el tema de la felicidad de las \n				personas, ya que, según los estudios de Mandomedio, actualmente un 76% de los ejecutivos \n				se quiere cambiar de trabajo, porque no está feliz con lo que hace más que por un mayor \n				sueldo. \n			</p>\n			<p>\n				Frente a este escenario, Ignacio González Lacoste, gerente general de la consultora explicó\n				que "para alcanzar el alto desempeño y mantenerlo se necesita trabajar con personas \n				felices, por lo cual quisimos comenzar con este tema,  que no sólo nos ayudará a manejar \n				mejor a nuestros equipos de trabajo, sino a ser mejores personas".\n			</p>\n			<p>\n				En esta oportunidad, el Club Líderes de RRHH contó con la participación del Director de Personas de la Universidad de Los Andes, Miguel Figueroa Diesel, quien invitó a los gerentes a preguntarse qué es la felicidad y si la empresa es responsable de la felicidad de las personas. \n			</p>\n			<p>\n				"La respuesta no es fácil, porque la persona es un muy buen material, pero complejo y por lo tanto es necesario conocerla y para eso tenemos que reconocernos como sujetos de valores, necesidades materiales y trascendentales, sólo de esta forma podremos contratar las personas idóneas para trabajar en cada cargo y empresa", explicó  Miguel Figueroa.\n			</p>\n			<p>\n				En este sentido, Figueroa señala que es imperativo transitar hacia la persona, ponerla como centro de la empresa; y para hacerlo hay que partir cambiando el lenguaje y dejar de hablar de recursos humanos o de capital humano y decir gerencia de personas o proceso de bienvenida en vez de proceso de inducción. \n			</p>\n			<p>\n				Según Miguel Figueroa "siguiendo esta lógica nos acercamos más a la persona y a su felicidad, pero un detalle importante es entenderla como un proceso de mejora continua donde es imperioso estar pendiente de lo que necesita el colaborador, lo que siente y lo que busca. Cómo voy a lograr que mi trabajo exceda en grandeza, si no me tratan bie".\n			</p>\n			<p>\n				En este primer encuentro, realizado con un desayuno en el Hotel Marriott, ejecutivos de RRHH de Nestlé, Rabobank,  Corpbanca, Watt’s, Universidad Adolfo Ibañez, entre otras empresas, también tuvieron la oportunidad de conocer el caso Miniclinic, innovador servicio de salud ubicado en locales junto a grandes supermercados que proporciona atención médica rápida en caso de enefermedades y heridas menores, chequeo médico general, y revisión de exámenes, sin solicitud previa de horas. \n			</p>\n			<p>\n				Patricio Millas, fundador y gerente general de Miniclinic, explicó que "esta idea de negocio surgió para responder a una necesidad que tienen hoy las personas de cubrir en poco tiempo y cerca de sus actividades a consultas médicas con una atención cálida, que requiere profesionales que se adapten a este formato, lo que ha sido un desafío interesante en el mundo de la salud". \n			</p>\n			<p>\n				El Club Líderes de RRHH de Mandomedio se reunirá cada dos meses para analizar temas que le permitan a los encargados de gestionar el capital humano de las organizaciones, conocer sobre nuevas tendencias para administrar el talento organizacional y debatir sobre los desafíos de esta área tan importante para el crecimiento de las empresas.\n			</p>\n			<div >\n				<img src="{base-url}/resources/img/blog/clublideres1.png" />\n				<img src="{base-url}/resources/img/blog/clublideres2.png" />\n				<img src="{base-url}/resources/img/blog/clublideres3.png" />\n				<img src="{base-url}/resources/img/blog/clublideres4.png" />\n				<img src="{base-url}/resources/img/blog/clublideres5.png" />\n				<img src="{base-url}/resources/img/blog/clublideres6.png" />\n\n			</div>\n			\n	'),
(5, '2013-05-27', 'Consejos para superar con éxito un proceso de selección', '\n			<p class="date">Santiago, 27 de mayo de 2013.-</p>\n			<h3>\n				Cumplir los plazos, avisar si no puedes asistir a una entrevista y entregar información real son claves para obtener resultados positivos al buscar empleo.\n			</h3>\n			<p>\n				Al momento de buscar un trabajo son varias las etapas por las que hay que pasar y se debe estar atento a distintos detalles que podrían llegar a marcar la diferencia frente a los demás candidatos.\n			</p>\n			<p>\n				"Es recomendable que cuando una persona sea citada a una entrevista laboral debe confirmar su asistencia y asistir, o justificar con tiempo su inasistencia ya que es muy mal visto no llegar a una entrevista sin avisar y puede ser perjudicial para sus futuras búsquedas de empleo", dice María de Atucha, Jefa de Mandomedio Selección\n			</p>\n			<p>\n				Para superar con éxito un proceso de selección y obtener el empleo, María de Atucha, Jefa de Mandomedio Selección recomienda:\n			</p>\n			<ul>\n				<li>\n					<b>Una adecuada presentación personal:</b> Esto habla de preocupación, orden y formalidad, es importante dar una buena primera impresión y cuidar la sobriedad tanto en el peinado y vestuario como en el maquillaje.  \n				</li>\n				<li>\n					<b>Enviar lo que se solicita en los tiempos pedidos.</b> Es común que se pidan datos de referencia o algún documento e incluso cvs que si no envías en el plazo puedes atrasar el proceso o quedar fuera.\n				</li>\n				<li>\n					<b>Avisar si no puedes asistir a una entrevista.</b> Si no puedes asistir a la entrevista agendada es importante avisar con anticipación para así poder coordinar un nuevo encuentro.\n				</li>\n				<li>\n					<b>Informar cuando están en otros procesos de selección.</b> Por si llegas a ser llamado de otro empleo antes.\n				</li>\n				<li>\n					<b>Tener claridad de su cv:</b> Es importante estar al tanto de las fechas de inicio y término de los trabajos en los cuales ha estado y también de las funciones realizadas. \n				</li>\n				<li>\n				<b>Responder acorde a lo que se está preguntando:</b> Es importante dar respuestas acotadas según la pregunta del evaluador, “muchas veces los candidatos se dan muchas vueltas para responder o simplemente responden lo que ellos quieren que el evaluador sepa. Esto genera que se pierda el foco de la conversación y por lo tanto, vale la pena tomarse un tiempo y pensar bien en lo que se dirá”, declara María de Atucha.			\n				</li>\n				<li>\n				<b>Entregar referencias verdaderas.</b> Mentir o entregar información falsa puede perjudicar tu reputación laboral.\n				</li>\n				<li>\n				<b>Tener buena actitud.</b> En toda entrevista laboral tener una actitud positiva es clave para generar una buena impresión y demostrar interés en el cargo, es importante ser respetuoso, cuidar el vocabulario y ser amable.\n				</li>\n			</ul>\n			<div class="imagecaption">\n				<img src="{base-url}/resources/img/blog/superarconexito.png"/>\n			</div>		\n		'),
(6, '2013-07-08', 'Solo el 39% de los ejecutivos se siente feliz en su trabajo', '					<p class="date">Santiago, 8 julio de 2013.-</p>\n						<h3>Los profesionales declaran que serían más felices si su\n							empresa les entrega proyección profesional y existe un grado de\n							insatisfacción con los jefes y la renta.</h3>\n						<p>El empleo es una variable que afecta directamente en la\n							felicidad de las personas. Según el primer Estudio de Felicidad\n							Laboral realizado por Mandomedio S.A. solo el 39% de los\n							ejecutivos se siente feliz en su trabajo y el 84% siente que es\n							más feliz fuera de su empleo. Un grupo de 430 ejecutivos, que\n							desempeñan desde cargos profesionales a gerentes generales,\n							fueron encuestados durante junio por dicha empresa de búsqueda de\n							ejecutivos.</p>\n						<p>El 69% de los encuestados trabaja para cubrir sus gastos\n							básicos y el 14% lo hace para adquirir bienes suntuarios o\n							viajes.</p>\n						<p>Entre los factores que ayudarían a los profesionales a\n							sentirse más feliz en su empleo los más valorados fueron la\n							proyección laboral (82%), flexibilidad horaria (73%) y\n							capacitación (72%) .</p>\n						<p>"El desarrollo de carrera es fundamental para aportar\n							felicidad a las personas, esto queda demostrado porque según\n							datos del estudio los más felices son aquellos que han alcanzado\n							un cargo más alto, además, los ejecutivos valoran altamente la\n							capacitación y coaching en sus empleos", menciona Ignacio\n							González, Gerente General de Mandomedio.</p>\n						<p>La investigación también indagó en cómo los ejecutivos\n							podrían alcanzar la felicidad en su vida y las variables\n							mayormente mencionadas sobre el 85% fueron tener un buen trabajo,\n							más tiempo para compartir con la familia y una buena educación.</p>\n						<p>En cuanto a la vida familiar el 54% de los ejecutivos\n							considera que dispone de suficiente tiempo para compartir con su\n							familia.</p>\n						<p>Los ejecutivos están medianamente de acuerdo con su nivel\n							de renta debido a que solo el 54% dijo que su renta cubre sus\n							necesidades, esta situación varía según la jerarquía del cargo,\n							el 41% de los profesionales dijo que su sueldo cubre sus\n							necesidades, el 50% de las jefaturas y el 73% de las gerencias\n							señalaron esto.</p>\n						<p>Además, el 41% de los encuestados opina que su sueldo es\n							acorde al mercado, y además, el 28% de los ejecutivos indicó\n							tener un alto nivel de deuda.</p>\n						<p>De los ejecutivos que se sienten felices en su trabajo, el\n							57% de ellos dijo que tiene una renta acorde al mercado.</p>\n					\n					<h3 class="title">Ambiente laboral</h3>\n					\n						<p>Solo el 54% de los ejecutivos considera que posee un buen\n							jefe, y en cuanto a la satisfacción con su empresa el 56% de los\n							ejecutivos se encuentra satisfecho.</p>\n						<p>En tanto, el 65% de los ejecutivos considera que trabaja\n							bajo presión, y el 73% de los ejecutivos considera que está al\n							día con sus tareas.</p>\n						<p>"Estos indicadores representan una baja satisfacción de las\n							personas en sus trabajos, lo que demuestra que la felicidad de\n							los colaboradores no depende solo de un buen sueldo sino que\n							influyen otras variables como la personalidad del jefe así como\n							los beneficios y gratas condiciones laborales. El trabajo bajo\n							presión genera estrés, tanto como no disfrutar del empleo",\n							comenta Ignacio González.</p>\n						<div class="imagecaption">\n							<img src="{base-url}/resources/img/blog/felicidadlaboral.png" />\n						</div>		\n	');

-- --------------------------------------------------------

--
-- Table structure for table `contact_area`
--

CREATE TABLE IF NOT EXISTS `contact_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `contact_area`
--

INSERT INTO `contact_area` (`id`, `name`) VALUES
(1, 'Búsqueda de Ejecutivos'),
(2, 'Hunting'),
(3, 'Evaluación'),
(4, 'Coaching/Outplacement'),
(5, 'Ingresa CV'),
(6, 'Contacto (Empresa)'),
(7, 'Contacto (Candidatos)');

-- --------------------------------------------------------

--
-- Table structure for table `contact_message`
--

CREATE TABLE IF NOT EXISTS `contact_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send` enum('TRUE','FALSE') NOT NULL DEFAULT 'FALSE',
  `date` date NOT NULL,
  `name` varchar(90) NOT NULL,
  `lastname` varchar(90) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `country` enum('Chile','Colombia','Peru','Argentina') NOT NULL,
  `id_contact_area` int(11) NOT NULL,
  `message` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_contact_area` (`id_contact_area`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `contact_message`
--

INSERT INTO `contact_message` (`id`, `send`, `date`, `name`, `lastname`, `email`, `phone`, `country`, `id_contact_area`, `message`) VALUES
(2, 'TRUE', '2013-09-02', 'Benjamín Andrés', 'Almarza Alarcón', 'benjamin.almarza@gmail.com', '09-94001498', 'Chile', 7, 'fffffffffffff fdddddddfffffffffffff fdddddddfffffffffffff fdddddddfffffffffffff fdddddddfffffffffffff fdddddddfffffffffffff fddddddd'),
(3, 'FALSE', '2013-09-02', 'Benjamín Andrés', 'Almarza Alarcón', 'benjamin.almarza@gmail.com', '09-94001498', 'Chile', 1, 'mailSender.send();mailSender.send();mailSender.send();mailSender.send();mailSender.send();mailSender.send();mailSender.send();mailSender.send();mailSender.send();'),
(5, 'FALSE', '2013-09-02', 'Benjamín Andrés', 'Almarza Alarcón', 'benjamin.almarza@gmail.com', '09-94001498', 'Chile', 1, 'Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013'),
(6, 'FALSE', '2013-09-02', 'Benjamín Andrés', 'Almarza Alarcón', 'benjamin.almarza@gmail.com', '09-94001498', 'Chile', 1, 'Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013Lunes2013'),
(7, 'TRUE', '2013-09-02', 'Benjamín Andrés', 'Almarza Alarcón', 'benjamin.almarza@gmail.com', '09-94001498', 'Chile', 1, '################################################################################################'),
(8, 'TRUE', '2013-09-02', 'Benjamín Andrés', 'Almarza Alarcón', 'benjamin.almarza@gmail.com', '09-94001498', 'Chile', 1, 'Mensaje de pruebas\r\nMensaje de pruebas\r\nMensaje de pruebas\r\nMensaje de pruebas\r\nMensaje de pruebas');

-- --------------------------------------------------------

--
-- Table structure for table `contact_person`
--

CREATE TABLE IF NOT EXISTS `contact_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` enum('Chile','Colombia','Peru','Argentina') NOT NULL DEFAULT 'Chile',
  `id_contact_area` int(11) NOT NULL,
  `mail` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_contact_area` (`id_contact_area`),
  KEY `id_contact_country` (`country`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `contact_person`
--

INSERT INTO `contact_person` (`id`, `country`, `id_contact_area`, `mail`) VALUES
(1, 'Chile', 1, 'benjamin.almarza@gmail.com'),
(2, 'Argentina', 1, 'smosquera@mandomedio.com'),
(3, 'Peru', 1, 'ecespedes@mandomedio.com'),
(4, 'Colombia', 1, 'jnieto@mandomedio.com'),
(5, 'Chile', 2, 'smosquera@mandomedio.com'),
(6, 'Argentina', 2, 'smosquera@mandomedio.com'),
(7, 'Peru', 2, 'ecespedes@mandomedio.com'),
(8, 'Colombia', 2, 'jnieto@mandomedio.com'),
(9, 'Chile', 3, 'sfritz@mandomedio.com'),
(10, 'Argentina', 3, 'agomez@mandomedio.com'),
(11, 'Peru', 3, 'ecespedes@mandomedio.com'),
(12, 'Colombia', 3, 'jnieto@mandomedio.com'),
(13, 'Chile', 4, 'aovalle@mandomedio.com'),
(14, 'Argentina', 4, 'aovalle@mandomedio.com'),
(15, 'Peru', 4, 'aovalle@mandomedio.com'),
(16, 'Colombia', 4, 'aovalle@mandomedio.com'),
(17, 'Argentina', 5, 'ctrepiana@mandomedio.com'),
(18, 'Chile', 5, 'ctrepiana@mandomedio.com'),
(19, 'Colombia', 5, 'jnieto@mandomedio.com'),
(20, 'Peru', 5, 'nmorales@mandomedio.com'),
(21, 'Chile', 6, 'smosquera@mandomedio.com'),
(22, 'Argentina', 6, 'smosquera@mandomedio.com'),
(23, 'Peru', 6, 'ecespedes@mandomedio.com'),
(25, 'Chile', 7, 'ctrepiana@mandomedio.com'),
(26, 'Argentina', 7, 'ctrepiana@mandomedio.com'),
(27, 'Peru', 7, 'nmorales@mandomedio.com'),
(28, 'Colombia', 7, 'jnieto@mandomedio.com'),
(30, 'Colombia', 6, 'jnieto@mandomedio.com'),
(31, 'Peru', 6, 'igonzalez@mandomedio.com'),
(32, 'Chile', 6, 'igonzalez@mandomedio.com'),
(33, 'Colombia', 6, 'igonzalez@mandomedio.com'),
(34, 'Peru', 1, 'igonzalez@mandomedio.com');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `safe_name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `name`, `safe_name`) VALUES
(0, 'all', 'all'),
(1, 'Chile', 'chile'),
(2, 'Perú', 'peru'),
(3, 'Colombia', 'colombia'),
(4, 'Argentina', 'argentina');

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE IF NOT EXISTS `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `country_id` int(11) NOT NULL,
  `area_id` int(11) NOT NULL,
  `contacto` varchar(100) NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `job_area`
--

CREATE TABLE IF NOT EXISTS `job_area` (
  `id` int(11) NOT NULL,
  `name` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `press`
--

CREATE TABLE IF NOT EXISTS `press` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` enum('Chile','Colombia','Peru','Argentina','all') DEFAULT NULL,
  `date` date NOT NULL,
  `type` enum('video','communicate','study','news') NOT NULL DEFAULT 'news',
  `external` enum('TRUE','FALSE') NOT NULL DEFAULT 'TRUE',
  `url` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `resume` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `press`
--

INSERT INTO `press` (`id`, `country`, `date`, `type`, `external`, `url`, `title`, `image`, `resume`) VALUES
(4, 'Chile', '2013-06-01', 'news', 'TRUE', 'http://www.pulso.cl/multimedia/programa/2013/07/54-2029-4-mandomedio-rompiendo-mitos-del-estres-laboral.shtml', 'Entrevista de Rodrigo Correa en Pulso TV.', 'pulso.png', 'Mandomedio: rompiendo mitos del estrés laboral'),
(5, 'Chile', '2013-06-21', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/06/21/EmpresasyPoder-5', 'Nombramiento de María Soledad Mosquera en la revista Empresas & Poder', 'empresaypoder.png', 'Una nueva gerenta de Negocios y Operaciones tiene la empresa especializada en búsqueda y evaluación, coaching y outplacement profesionales de cargos medios, Mandomedio.'),
(6, 'Chile', '2013-07-11', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/07/11/Pulso-6', 'Columna de Soledad Mosquera en Pulso.', 'pulso.png', 'No hay una segunda oportunidad para dar la primera mejor impresión. Cuando nos enfrentamos a un producto, el envoltorio habla mucho del contenido.'),
(7, 'Chile', '2013-07-10', 'news', 'TRUE', 'http://educamericas.cl/articulos/actualidad/%C2%BFcomo-construir-organizaciones-que-concilien-los-valores', 'Nota sobre seminario valores en Educaméricas.', 'educamericas.png', 'Para alinear a una empresa y sus colaboradores es necesario tener los valores organizacionales definidos y que estos sean el núcleo de la organización.'),
(8, 'Chile', '2013-07-08', 'news', 'TRUE', 'http://mba.americaeconomia.com/articulos/notas/como-dirigir-la-empresa-mediante-valores', 'Nota dirección de empresas por valores en América Economía.com', 'mba.png', '¿Cómo dirigir la empresa mediante valores?'),
(9, 'Chile', '2013-07-08', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/noticia_pescrita.php?nota=9496480', 'Menos del 40% de los ejecutivos es feliz con su trabajo', 'mercurio.png', 'Los colaboradores aseguran que si las empresas les ofrecen proyección, flexibilidad horaria y capacitación, podrían estar mejor.'),
(10, 'Peru', '2013-07-04', 'news', 'TRUE', 'http://educamericas.cl/articulos/actualidad/mandomedio-peru-como-seleccionar-talentos-con-exito', 'Mandomedio Perú: Cómo seleccionar talentos con éxito', 'educamericas.png', 'Cuando éstas necesitan seleccionar un nuevo ejecutivo, primero deben hacer un diagnóstico sobre qué es lo que necesitan para aportar a su estrategia y mejorar la productividad'),
(11, 'Peru', '2013-07-05', 'news', 'TRUE', 'http://www.eleconomistaamerica.com/actualidad-eAm-usa/noticias/4970055/07/13/Cinco-claves-para-seleccionar-talentos-con-exito.html', 'El talento de reconocer, cinco claves para seleccionar al candidato ideal', 'eleconomista.png', 'Durante los primeros años del siglo xx, hubo un escritor estadounidense, de nombre Elbert y de apellido Hubbard, que asimiló a la perfección la dificultad a la que se enfrentan a diario los trabajadores de un departamento de recursos humanos.'),
(12, 'Chile', '2013-07-03', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/07/03/Publimetro-16', 'Encuesta: 60% admite tener un compañero "insoportable"', 'publimetro.png', 'Sondeo PublimetroUniversidad Central. Algunos trabajadores incluso están dispuestos a renunciar para evitar a quien sienten los condiciona laboralmente'),
(13, 'Peru', '2013-07-02', 'news', 'TRUE', 'http://mba.americaeconomia.com/articulos/notas/cinco-claves-para-seleccionar-talentos-con-exito', 'Cinco claves para seleccionar talentos con éxito', 'mba.png', 'De acuerdo con Erika Céspedes, gerente de Mandomedio Perú, seguir estos pasos mejora el clima laboral, disminuye la rotación y aumenta la productividad.'),
(14, 'Peru', '2013-07-01', 'news', 'TRUE', 'http://www.infocapitalhumano.pe/movidas-y-noticias.php?id=1563&t=cinco-claves-para-seleccionar-talentos-con-exito', 'Cinco claves para seleccionar talentos con éxito', 'capitalhumano.png', 'Tener un plan de reclutamiento definido y establecer las características del candidato ayudarán a que las empresas no comentan un error en la selección de ejecutivos que se puede traducir en un alto costo.'),
(15, 'Peru', '2013-06-28', 'news', 'TRUE', 'http://economia.terra.com.pe/noticias/noticia.aspx?idNoticia=201306281947_TRR_82317844', '¿Tiene una empresa?: cinco pasos para seleccionar talentos con éxito', 'terra.png', 'Cuando las empresas necesitan seleccionar un nuevo ejecutivo, primero deben hacer un diagnóstico sobre qué perfil requieren para efectuar una correcta elección.'),
(16, 'Chile', '2013-07-01', 'news', 'TRUE', 'www.educamericas.com/articulos/actualidad/consultora-mandomedio-promueve-primer-club-de-lideres-de-rrhh', 'Consultora Mandomedio promueve primer Club de Líderes de RRHH', 'educamericas.png', 'Con la presencia de gerentes de Recursos Humanos de importantes empresas chilenas, partió el primer encuentro del Club de Líderes de RRHH'),
(17, 'all', '2013-07-01', 'video', 'TRUE', 'http://www.pulso.cl/multimedia/video/2013/07/50-1997-4-mandomedio-construyendo-organizaciones-gestionadas-por-valores.shtml', 'Entrevista de Hernán Cerna en Pulso TV', 'Mandomedio_SA_entrevista_HCerna_valores_Pulso_TV_1-7-2013.jpg', 'Mandomedio: Construyendo organizaciones gestionadas por valores'),
(18, 'Chile', '2013-07-01', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/07/01/ElMercurio-B12', 'Sube integración de empleados en las metas estratégicas.', 'mercurio.png', 'La planificación estratégica con las metas y objetivos del año en general se hace entre directivos.'),
(19, 'Colombia', '2013-05-08', 'news', 'TRUE', 'http://www.portafolio.co/negocios/firma-cazatalentos-chilena-llega-colombia', 'Consultora chilena llega a ‘cazar’ mandos medios en el país', 'portafolio.png', 'Bajo la premisa de guiar a las compañías del país a encontrar los empleados perfectos para los cargos intermedios de la organización (como profesionales, directores y subgerentes), llegó a Colombia Mandomedio, una consultora de origen chileno que también tiene presencia en Argentina, Chile y Perú.'),
(20, 'Chile', '2013-05-08', 'news', 'TRUE', 'http://www.eleconomistaamerica.cl/reportajes-en-eAm-chl/noticias/4810273/05/13/Chilenos-mas-exigentes-al-cambiar-de-trabajo.html', 'Chilenos más exigentes al cambiar el trabajo', 'eleconomista.png', 'La empresa caza talentos Mandomedio detectó que el 27% de los candidatos chilenos desiste de participar de un proceso de selección que no llene sus expectativas.'),
(21, 'Chile', '2013-06-28', 'news', 'TRUE', 'http://educamericas.cl/articulos/reportajes/las-ventajas-y-desventajas-de-tomar-decisiones-en-equipo', 'Las ventajas y desventajas de tomar decisiones en equipo.', 'educamericas.png', 'El trabajo colaborativo es lo que distingue a un equipo de un grupo de trabajo. En un equipo el líder y sus colaboradores reman juntos en pro de los objetivos de la empresa.'),
(22, 'Chile', '2013-06-27', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/06/26/Pulso-8', 'Empleabiidad', 'lanacion.png', 'El desarrollo profesional es uno de los principales intereses de los ejecutivos hoy, sin embargo, éste no llega solo.'),
(23, 'Chile', '2013-06-26', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/06/22/Cr%F3nica_Chill%E1n-9', 'Empleabilidad', 'cronicachillan.png', 'El desarrollo profesional es uno de los principales intereses de los ejecutivos hoyen día, sin embargo, este no llega solo.'),
(24, 'Chile', '2013-06-22', 'news', 'TRUE', 'http://www.diarioatacama.cl/impresa/2013/06/22/full/9/', 'Desarrollo profesional  / Colaboración Rodrigo Correa', 'diarioatacama.png', 'El desarrollo profesional no llega solo'),
(25, 'Chile', '2013-06-22', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/noticia_pescrita.php?nota=9428842', 'Desarrollo profesional  / Colaboración Rodrigo Correa', 'cronicachillan.png', 'El desarrollo profesional no llega solo'),
(26, 'Chile', '2013-06-24', 'news', 'TRUE', 'http://educamericas.com/articulos/reportajes/%C2%BFcomo-tener-empleados-felices', '¿Cómo tener empleados felices?', 'educamericas.png', 'Si la felicidad es un estado mental que se produce cuando una persona cree haber alcanzado una meta deseada, es fácil intuir que para ser felices en el trabajo éste debe entregar la posibilidad de alcanzar objetivos y desafíos propios'),
(27, 'Chile', '2013-06-24', 'news', 'TRUE', 'http://economia.terra.cl/noticias/noticia.aspx?idNoticia=201306221100_TRR_82298423', 'Conozca cómo manejar el estrés en su lugar de trabajo', 'terra.png', 'Actualmente las empresas son más competitivas y existe mayor presión por cumplir las metas, lo que muchas veces desencadena estrés en los empleados.'),
(29, 'Chile', '2013-06-19', 'news', 'TRUE', 'http://mba.americaeconomia.com/articulos/notas/consultora-chilena-realizo-reunion-para-debatir-sobre-la-felicidad-laboral', 'Consultora chilena realizó reunión para debatir sobre la felicidad laboral', 'mba.png', 'Mediante la iniciativa de Mandomedio, denominada Club de Líderes de RRHH, se reunieron encargados de capital humano de diversas empresas y casas de estudio.'),
(30, 'Chile', '2013-06-18', 'news', 'TRUE', 'http://vi.cl/social/segun-mandomedio-seleccion-consejos-para-superar-con-exito-un-proceso-de-seleccion ', 'Según Mandomedio Selección: Consejos para superar con éxito un proceso de selección', 'vi.png', 'Cumplir los plazos, avisar si no puedes asistir a una entrevista y entregar información real son claves para obtener resultados positivos al buscar empleo.'),
(31, 'Colombia', '2013-06-17', 'news', 'TRUE', 'http://www.portafolio.co/portafolio-plus/el-27-los-empleados-rechaza-ofertas-laborales', 'El 27 % de los empleados rechaza ofertas laborales', 'portafolio.png', 'Aunque los profesionales buscan oportunidades, son más exigentes a la hora de elegir, dice estudio de Mandomedio realizado a 1000 profesionales en Colombia'),
(32, 'Chile', '2013-07-17', 'news', 'TRUE', 'http://www.pulso.cl/multimedia/programa/2013/06/54-1886-4-mandomedio-las-claves-para-una-capacitacion-laboral-efectiva.shtml ', 'Mandomedio: las claves para una capacitación laboral efectiva', 'pulso.png', 'Entrevista a Rodrigo Correa'),
(33, 'Chile', '2013-06-27', 'news', 'TRUE', 'http://www.nexchannel.cl/Nex/noticias/ver_imagen.php?img=2013/06/17/Estrategia-4', 'La Personalidad del Gerente y el Equipo', 'estrategia.png', 'Tras estudiar más de 400 casos de empresas medianas y grandes en EE.UU., Robert Hogan, reconocido por sus innovaciones en pruebas de personalidad y liderazgo en las organizaciones, concluyó que entre el 50% y 70% de los directivos son incompetentes y malos gerentes, porque no motivan ni despiertan compromiso entre sus colaborador.'),
(34, 'Colombia', '2013-06-11', 'news', 'TRUE', 'http://www.larepublica.co/empresas/bavaria-apela-la-alegr%C3%ADa-de-los-colombianos-para-ejecutar-una-nueva-forma-de-mercadeo_40372', 'Aumentan los ambientes felices en las compañías', 'larepublica.png', 'Bavaria apela a la alegría de los colombianos para ejecutar una nueva forma de mercadeo.'),
(35, 'Chile', '2013-06-10', 'news', 'TRUE', 'http://www.estrategiaynegocios.net/blog/2013/06/10/ocho-consejos-para-superar-con-exito-un-proceso-de-seleccion/', 'Ocho consejos para superar con éxito un proceso de selección', 'eyn.png', 'Al buscar un trabajo son varias las etapas que hay que atravesar. Se debe estar atento a distintos detalles que podrían llegar a marcar diferencia'),
(36, 'Peru', '2013-06-15', 'news', 'TRUE', 'http://www.infocapitalhumano.pe/movidas-y-noticias.php?id=1563&t=cinco-claves-para-seleccionar-talentos-con-exito', 'Cinco claves para seleccionar talentos con éxito', 'capitalhumano.png', 'Tener un plan de reclutamiento definido y establecer las características del candidato ayudarán a que las empresas no comentan un error en la selección de ejecutivos que se puede traducir en un alto costo.'),
(37, 'all', '2013-04-15', 'communicate', 'FALSE', '1', 'Nueva Gerente de Negocios y Operaciones en Mandomedio', 'soledadmosquera1.png', 'María Soledad Mosquera Rojas asumió como nueva Gerente de Negocios y Operaciones de la consultora Mandomedio'),
(38, 'all', '2013-07-08', 'communicate', 'FALSE', '2', 'Nuevo Director de Desarrollo Internacional en Mandomedio S.A.', 'andresgomez1.png', 'Andrés Gómez López asumió como Director de Desarrollo Internacional de Mandomedio S.A.'),
(39, 'all', '2013-05-07', 'communicate', 'FALSE', '3', 'La personalidad del líder define el éxito de la empresa', 'mmhogan.png', 'El especialista Robert Hogan estuvo en nuestro país, patrocinado por Mandomedio'),
(40, 'all', '2013-06-11', 'video', 'TRUE', 'http://www.pulso.cl/multimedia/programa/2013/06/54-1886-4-mandomedio-las-claves-para-una-capacitacion-laboral-efectiva.shtml', 'Entrevista de Rodrigo Correa en Pulso TV quien habla sobre cómo lograr una capacitación laboral  efe', 'Mandomedio_Consulting_Pulso_TV_11-6-2013.jpg', ''),
(41, 'all', '2013-07-10', 'video', 'TRUE', 'http://www.pulso.cl/multimedia/programa/2013/07/54-2029-4-mandomedio-rompiendo-mitos-del-estres-laboral.shtml', 'Entrevista de Rodrigo Correa en Pulso TV.', 'Mandomedio_Consulting_Pulso_TV_10-7-2013.jpg', ''),
(42, 'all', '2013-06-12', 'communicate', 'FALSE', '4', 'Mandomedio da el vamos a Club de Líderes de RRHH', 'clublideres.png', 'Partió el primer encuentro del Club de Líderes de RRHH'),
(44, 'all', '2013-05-27', 'communicate', 'FALSE', '5', 'Consejos para superar con éxito un proceso de selección', 'superarconexito1.png', 'Útiles consejos para superar con éxito un proceso de selección'),
(45, 'all', '2013-07-08', 'communicate', 'FALSE', '6', 'Solo el 39% de los ejecutivos se siente feliz en su trabajo', 'felicidadlaboral1.png', 'Los profesionales declaran que serían más felices si su empresa les entrega proyección profesional');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact_message`
--
ALTER TABLE `contact_message`
  ADD CONSTRAINT `contact_message_ibfk_1` FOREIGN KEY (`id_contact_area`) REFERENCES `contact_area` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contact_person`
--
ALTER TABLE `contact_person`
  ADD CONSTRAINT `contact_person_ibfk_2` FOREIGN KEY (`id_contact_area`) REFERENCES `contact_area` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `job_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
