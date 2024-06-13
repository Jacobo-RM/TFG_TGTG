-- Crear la base de datos y configurar opciones iniciales
CREATE DATABASE IF NOT EXISTS gestionTGTG;
USE gestionTGTG;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

-- Configuración de caracteres y collation
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- Tabla de empresaECI
CREATE TABLE IF NOT EXISTS `empresaECI` (
    `cod_empresa` VARCHAR(20) NOT NULL,
    `cif` VARCHAR(9) NOT NULL,
    `cuenta_SS` INT(9) NOT NULL,
    `domicilio` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(255) NOT NULL,
    `correo` VARCHAR(100) NOT NULL,
    `url_Web` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`cod_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de clientes
CREATE TABLE IF NOT EXISTS `clientes` (
    `nif_cliente` VARCHAR(10) NOT NULL,
    `nombre` VARCHAR(100) NOT NULL,
    `direccion` VARCHAR(100) NOT NULL,
    `telefono` VARCHAR(9) NOT NULL,
    `correo` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`nif_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de empleados
CREATE TABLE IF NOT EXISTS `empleados` (
    `nombre` VARCHAR(100) NOT NULL,
    `puesto_laboral` VARCHAR(100) NOT NULL,
    `naf` VARCHAR(12) NOT NULL,
    `horario_entrada` BIGINT(20) NOT NULL,
    `horario_salida` BIGINT(20) NOT NULL,
    `cod_empresa` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`naf`),
    FOREIGN KEY (`cod_empresa`) REFERENCES `empresaECI`(`cod_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de productos
CREATE TABLE IF NOT EXISTS `productos` (
    `cod_producto` VARCHAR(100) NOT NULL,
    `nombre` VARCHAR(100) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL,
    `precio_actual` DOUBLE NOT NULL,
    `precio_original` DOUBLE NOT NULL,
    `num_Serie` INT(15) NOT NULL,
    `categoria` VARCHAR(255) NOT NULL,
    `desperfecto` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de inventario
CREATE TABLE IF NOT EXISTS `inventario` (
    `cod_inventario` VARCHAR(11) NOT NULL,
    `cod_empresa` VARCHAR(11) NOT NULL,
    `descripcion` VARCHAR(255),
    PRIMARY KEY (`cod_inventario`),
    FOREIGN KEY (`cod_empresa`) REFERENCES `empresaECI`(`cod_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de inventario_productos para la relación muchos a muchos entre inventarios y productos
CREATE TABLE IF NOT EXISTS `inventario_productos` (
    `cod_inventario` VARCHAR(11) NOT NULL,
    `cod_producto` VARCHAR(100) NOT NULL,
    `cantidad` INT NOT NULL,
    FOREIGN KEY (`cod_inventario`) REFERENCES `inventario`(`cod_inventario`),
    FOREIGN KEY (`cod_producto`) REFERENCES `productos`(`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



-- Inserción de datos en la tabla empresaECI
INSERT INTO `empresaECI` (`cod_empresa`, `cif`, `cuenta_SS`, `domicilio`, `telefono`, `correo`, `url_Web`) VALUES
('1', 'A28017895', 555501234, 'Av. Nueva Montaña', '942 32 84 00', 'clientes@elcorteingles.es', 'https://www.elcorteingles.es/');

-- Inserción de datos en la tabla clientes
INSERT INTO `clientes` (`nif_cliente`, `nombre`, `direccion`, `telefono`, `correo`) VALUES
('114-30-166', 'Kandace Gerbel', 'Suite 87', '+55 (476) 511-0', 'kandace.gerbel@example.com'),
('134-91-565', 'Tony Griswood', 'Apt 458', '+375 (846) 937-', 'tony.griswood@example.com'),
('153-43-463', 'Halsey Cauldwell', 'Suite 60', '+48 (574) 118-2', 'halsey.cauldwell@example.com'),
('156-91-760', 'Willa Gianasi', 'Suite 53', '+7 (859) 170-86', 'willa.gianasi@example.com'),
('178-12-177', 'Erminia Lansberry', 'Apt 373', '+251 (261) 922-', 'erminia.lansberry@example.com'),
('179-79-527', 'Tiertza Drabble', 'Suite 11', '+60 (265) 574-3', 'tiertza.drabble@example.com'),
('181-44-753', 'Fax Ginglell', '11th Floor', '+385 (775) 158-', 'fax.ginglell@example.com'),
('196-76-303', 'Joanna Milington', 'PO Box 24762', '+30 (137) 139-7', 'joanna.milington@example.com'),
('201-99-609', 'Brnaby Stollberger', 'PO Box 88251', '+55 (860) 216-6', 'brnaby.stollberger@example.com'),
('212-35-708', 'Pier Clacson', 'Apt 1546', '+98 (694) 344-0', 'pier.clacson@example.com'),
('212-94-214', 'Monro Durbann', '11th Floor', '+48 (590) 157-4', 'monro.durbann@example.com'),
('225-83-888', 'Pavia Milan', 'Apt 878', '+86 (359) 903-0', 'pavia.milan@example.com'),
('231-56-949', 'Sampson Kirrage', 'Apt 167', '+46 (137) 746-1', 'sampson.kirrage@example.com'),
('234-92-188', 'Debi Berndsen', 'Suite 10', '+1 (812) 619-09', 'debi.berndsen@example.com'),
('243-26-153', 'Will Pirkis', '7th Floor', '+7 (893) 549-73', 'will.pirkis@example.com'),
('248-35-406', 'Nessy Awin', 'Apt 544', '+51 (664) 367-9', 'nessy.awin@example.com'),
('280-21-238', 'Peadar Mayman', 'Room 1258', '+30 (451) 255-7', 'peadar.mayman@example.com'),
('283-40-254', 'Hershel Fransoni', 'Apt 266', '+55 (798) 273-1', 'hershel.fransoni@example.com'),
('287-16-629', 'Garik Brizland', 'PO Box 36414', '+255 (714) 156-', 'garik.brizland@example.com'),
('290-93-859', 'Erastus Taffrey', 'PO Box 37685', '+55 (685) 886-6', 'erastus.taffrey@example.com'),
('294-25-450', 'Lissa Routley', 'Room 1258', '+7 (663) 932-39', 'lissa.routley@example.com'),
('294-90-323', 'Sophi Holdall', 'PO Box 59712', '+63 (815) 180-3', 'sophi.holdall@example.com'),
('296-80-811', 'Deck Sandeland', 'Room 891', '+7 (124) 570-48', 'deck.sandeland@example.com'),
('302-06-134', 'Diarmid Posvner', 'Suite 51', '+86 (358) 820-2', 'diarmid.posvner@example.com'),
('310-02-795', 'Madelene Rycroft', 'Room 1183', '+33 (962) 191-0', 'madelene.rycroft@example.com'),
('310-17-247', 'Tove Rittmeier', 'Suite 47', '+98 (263) 137-3', 'tove.rittmeier@example.com'),
('316-80-803', 'Tremayne Cordier', 'Suite 13', '+86 (803) 353-3', 'tremayne.cordier@example.com'),
('323-22-534', 'Nanon Bulleyn', 'Room 1172', '+86 (560) 222-5', 'nanon.bulleyn@example.com'),
('326-69-900', 'Codee Giles', 'Apt 503', '+48 (796) 253-7', 'codee.giles@example.com'),
('328-20-132', 'Mable Tanby', 'Suite 92', '+86 (828) 868-1', 'mable.tanby@example.com'),
('336-02-638', 'Nicola Netley', 'Suite 50', '+7 (149) 207-03', 'nicola.netley@example.com'),
('337-92-277', 'Wallie Hindrich', 'Apt 1849', '+62 (493) 207-0', 'wallie.hindrich@example.com'),
('338-46-135', 'Jammie Nottingam', 'Apt 1004', '+49 (973) 761-5', 'jammie.nottingam@example.com'),
('348-74-958', 'Kizzie Loraine', 'Suite 89', '+992 (115) 784-', 'kizzie.loraine@example.com'),
('350-09-195', 'Adina Dredge', 'Room 643', '+212 (118) 582-', 'adina.dredge@example.com'),
('377-49-787', 'Hesther Rene', 'PO Box 93842', '+7 (235) 901-75', 'hesther.rene@example.com'),
('384-44-623', 'Dania Jessopp', 'PO Box 33713', '+62 (788) 463-2', 'dania.jessopp@example.com'),
('391-73-141', 'Bear Beston', 'Apt 1960', '+92 (537) 938-1', 'bear.beston@example.com'),
('402-39-795', 'Annalee Lansdale', 'Room 467', '+86 (754) 147-3', 'annalee.lansdale@example.com'),
('425-93-488', 'Megen Goodlake', 'PO Box 54294', '+57 (947) 846-6', 'megen.goodlake@example.com'),
('436-54-862', 'Ingaberg Maleney', 'Apt 1037', '+46 (130) 607-1', 'ingaberg.maleney@example.com'),
('441-50-750', 'Adlai Gallelli', 'Apt 1911', '+33 (969) 711-6', 'adlai.gallelli@example.com'),
('443-53-455', 'Margette Poyntz', '15th Floor', '+86 (611) 910-1', 'margette.poyntz@example.com'),
('448-89-112', 'Katey Studd', 'Apt 1201', '+234 (137) 873-', 'katey.studd@example.com'),
('464-77-618', 'Tiler Ludman', 'PO Box 8227', '+370 (287) 694-', 'tiler.ludman@example.com'),
('478-82-722', 'Aurthur Robertucci', '3rd Floor', '+266 (830) 599-', 'aurthur.robertucci@example.com'),
('486-94-379', 'Debi Hurst', 'Room 476', '+966 (854) 595-', 'debi.hurst@example.com'),
('492-19-359', 'Anitra Veivers', 'Room 106', '+46 (599) 959-4', 'anitra.veivers@example.com'),
('493-50-325', 'Diana Tudor', 'Suite 64', '+62 (817) 635-7', 'diana.tudor@example.com'),
('517-64-068', 'Herbert Goublier', 'Suite 48', '+48 (920) 718-0', 'herbert.goublier@example.com'),
('521-61-535', 'Phil Brickstock', 'Apt 1641', '+7 (160) 630-76', 'phil.brickstock@example.com'),
('525-84-432', 'Samuele Grevel', 'PO Box 25649', '+39 (844) 339-9', 'samuele.grevel@example.com'),
('532-05-230', 'Verney Abramsky', 'Apt 1478', '+976 (920) 871-', 'verney.abramsky@example.com'),
('535-03-539', 'Andrea Teague', '7th Floor', '+57 (286) 556-2', 'andrea.teague@example.com'),
('537-29-036', 'Engracia Doughartie', 'Room 913', '+1 (415) 179-01', 'engracia.doughartie@example.com'),
('543-75-798', 'Mathias Apthorpe', 'PO Box 49465', '+63 (543) 432-1', 'mathias.apthorpe@example.com'),
('548-96-722', 'Nanci Scryne', '2nd Floor', '+66 (748) 964-5', 'nanci.scryne@example.com'),
('556-49-391', 'Danya Bates', 'Apt 675', '+998 (126) 144-', 'danya.bates@example.com'),
('558-57-176', 'Juliana Godlee', 'Suite 17', '+63 (832) 708-5', 'juliana.godlee@example.com'),
('562-26-968', 'Leif Brodeau', 'PO Box 59245', '+386 (705) 485-', 'leif.brodeau@example.com'),
('564-68-005', 'Klemens De Cristoforo', 'Suite 40', '+48 (158) 917-9', 'klemens.decristoforo@example.com'),
('567-13-822', 'Cirilo Olivas', 'Suite 95', '+374 (668) 503-', 'cirilo.olivas@example.com'),
('571-53-197', 'Madelle Pinor', 'Room 687', '+7 (217) 649-22', 'madelle.pinor@example.com'),
('574-25-106', 'Inger Curgenuer', 'Room 228', '+967 (698) 194-', 'inger.curgenuer@example.com'),
('578-25-003', 'Chucho Doerffer', 'PO Box 37639', '+98 (191) 944-7', 'chucho.doerffer@example.com'),
('580-42-282', 'Anatollo Baynes', 'PO Box 48859', '+380 (749) 763-', 'anatollo.baynes@example.com'),
('610-89-296', 'Vevay Martensen', '18th Floor', '+225 (912) 624-', 'vevay.martensen@example.com'),
('615-61-287', 'Ray Arniz', 'Room 1248', '+62 (248) 869-8', 'ray.arniz@example.com'),
('646-09-469', 'Grace Janning', 'Apt 1349', '+86 (222) 371-4', 'grace.janning@example.com'),
('654-35-014', 'Miguelita Champain', 'Suite 48', '+48 (545) 439-6', 'miguelita.champain@example.com'),
('656-59-087', 'Thorvald Heustice', 'PO Box 29038', '+228 (367) 120-', 'thorvald.heustice@example.com'),
('664-83-520', 'Farlee Chipp', 'Suite 34', '+55 (704) 559-6', 'farlee.chipp@example.com'),
('680-06-512', 'Purcell Kunzelmann', 'Suite 86', '+86 (935) 295-3', 'purcell.kunzelmann@example.com'),
('684-47-077', 'Rosemaria Bowlands', '2nd Floor', '+385 (351) 388-', 'rosemaria.bowlands@example.com'),
('693-19-390', 'Gamaliel Dwelley', '7th Floor', '+7 (446) 557-30', 'gamaliel.dwelley@example.com'),
('699-80-674', 'Miguela Dootson', 'PO Box 67494', '+358 (605) 485-', 'miguela.dootson@example.com');

-- Inserción de datos en la tabla empleados
INSERT INTO `empleados` (`nombre`, `puesto_laboral`, `naf`, `horario_entrada`, `horario_salida`, `cod_empresa`) VALUES
('Emilio Rueda', 'Gerente', '280999999969', 1234567890, 9876543210, '1'),
('Esther Molino', 'Dependiente', '280956999969', 1234567890, 9876543210, '1');

-- Inserción de datos en la tabla productos
INSERT INTO `productos` (`cod_producto`, `nombre`, `descripcion`, `precio_actual`, `precio_original`, `num_Serie`, `categoria`, `desperfecto`) VALUES
('1', 'Assassins Creed Valhalla', 'Aventura épica en la era vikinga', 39.99, 59.99, 123456, 'Videojuego', 'Caja ligeramente dañada'),
('2', 'The Last of Us Part II', 'Emocionante historia de supervivencia', 29.99, 49.99, 789012, 'Videojuego', 'Empaque con pequeñas rasgaduras'),
('3', 'Cyberpunk 2077', 'Explora un futurista Night City', 49.99, 69.99, 345678, 'Videojuego', 'Etiqueta desprendida'),
('4', 'FIFA 22', 'El simulador de fútbol más realista', 39.99, 59.99, 901234, 'Videojuego', 'Caja con marcas de aplastamiento'),
('5', 'Animal Crossing: New Horizons', 'Crea tu isla paradisíaca', 42.99, 54.99, 567890, 'Videojuego', 'Envase con leves abolladuras'),
('6', 'Samsung 4K UHD Smart TV', 'Pantalla de 55 pulgadas con HDR', 699.99, 999.99, 123456, 'TV', 'Pequeños arañazos en el borde'),
('7', 'LG OLED TV', 'Calidad de imagen impresionante', 999.99, 1299.99, 789012, 'TV', 'Caja con esquinas ligeramente dañadas'),
('8', 'Sony Bravia 65" 4K HDR TV', 'Experiencia cinematográfica en casa', 599.99, 899.99, 345678, 'TV', 'Leves marcas en la parte posterior'),
('9', 'TCL Roku TV', 'Smart TV con opciones de transmisión', 149.99, 449.99, 901234, 'TV', 'Rasguño superficial en la pantalla'),
('10', 'Vizio 50" 4K Ultra HD TV', 'Gran calidad a un precio asequible', 249.99, 549.99, 567890, 'TV', 'Caja con señales de manipulación'),
('11', 'Sonos Play:5', 'Altavoz inteligente con gran sonido', 459.99, 499.99, 123456, 'Altavoz', 'Leve desgaste en la rejilla frontal'),
('12', 'Bose SoundLink Revolve+', 'Altavoz portátil con graves profundos', 259.99, 299.99, 789012, 'Altavoz', 'Empaque con pequeñas arrugas'),
('13', 'JBL Charge 4', 'Altavoz Bluetooth resistente al agua', 89.99, 129.99, 345678, 'Altavoz', 'Etiqueta descolorida'),
('14', 'Apple HomePod', 'Calidad de audio excepcional', 309.99, 349.99, 901234, 'Altavoz', 'Pequeña abolladura en la parte inferior'),
('15', 'UE Megaboom 3', 'Altavoz inalámbrico con batería de larga duración', 159.99, 199.99, 567890, 'Altavoz', 'Caja con marcas de transporte'),
('16', 'Camiseta Nike Swoosh', 'Camiseta deportiva con logo Nike', 17.99, 29.99, null, 'Camiseta', 'Etiqueta desprendida'),
('17', 'Adidas Originals Trefoil Tee', 'Camiseta clásica de Adidas', 12.99, 24.99, null, 'Camiseta', 'Pequeña mancha en la manga'),
('18', 'Under Armour Tech 2.0 Tee', 'Camiseta de entrenamiento transpirable', 7.99, 19.99, null, 'Camiseta', 'Costura deshilachada en el dobladillo'),
('19', 'Puma Essentials Logo Tee', 'Camiseta cómoda con el logo de Puma', 10.99, 22.99, null, 'Camiseta', 'Envase con pequeñas perforaciones'),
('20', 'Reebok Classics Vector Tee', 'Camiseta retro con diseño Reebok', 15.99, 27.99, null, 'Camiseta', 'Leve decoloración en el estampado'),
('21', 'Vans Old Skool', 'Zapatillas clásicas de skate', 39.99, 59.99, null, 'Playera Vans', 'Caja con daños visibles'),
('22', 'Vans Authentic', 'Estilo auténtico y cómodo', 29.99, 49.99, null, 'Playera Vans', 'Etiqueta ligeramente despegada'),
('23', 'Vans Slip-On', 'Fácil de poner y quitar', 34.99, 54.99, null, 'Playera Vans', 'Suela con pequeñas marcas'),
('24', 'Vans Sk8-Hi', 'Zapatillas de caña alta para mayor sujeción', 44.99, 64.99, null, 'Playera Vans', 'Caja con rasguños'),
('25', 'Vans Era', 'Diseño clásico con suela waffle', 24.99, 44.99, null, 'Playera Vans', 'Tejido ligeramente desgarrado'),
('26', 'Kit Spaghetti Bolognese', 'Todo lo que necesitas para una deliciosa comida de pasta', 6.49, 12.99, null, 'Comida', 'Fecha de caducidad en una semana'),
('27', 'Aguacate Orgánico', 'Aguacates orgánicos de calidad premium', 1.49, 2.99, null, 'Comida', 'Envase con pequeños agujeros'),
('28', 'Caja de Chocolate Gourmet', 'Chocolates variados de alta calidad', 19.99, 39.99, null, 'Comida', 'Chocolates ligeramente derretidos'),
('29', 'Café en Grano Premium', 'Granos de café de origen único para entusiastas del café', 15.99, 29.99, null, 'Comida', 'Envase con pequeñas rasgaduras'),
('30', 'Pack de Snacks Saludables', 'Frutos secos y frutas deshidratadas surtidos', 1.99, 4.99, null, 'Comida', 'Caja con abolladuras'),
('31', 'Set de Construcción LEGO', 'Crea tus propias aventuras con bloques LEGO', 8.99, 14.99, null, 'Juguete', 'Pequeños arañazos en la superficie debido al transporte.'),
('32', 'Muñeca Interactiva', 'Muñeca que responde a comandos y gestos', 24.99, 39.99, null, 'Juguete', 'Envase ligeramente dañado, pero el producto está en perfectas condiciones.'),
('33', 'Juego de Mesa Educativo', 'Divertido y educativo para niños', 9.99, 24.99, null, 'Juguete', 'Embalaje con leves arrugas, pero el juguete está intacto.'),
('34', 'Puzzle 3D', 'Construye una réplica en 3D de tu personaje favorito', 4.99, 19.99, null, 'Juguete', 'Colores ligeramente más claros de lo esperado, pero funcionalidad completa.'),
('35', 'Pelota de Fútbol para Niños', 'Pelota diseñada para niños pequeños', 9.99, 12.99, null, 'Juguete', 'Etiqueta con pequeño desgaste, pero el juguete es completamente nuevo.'),
('36', 'Cámara DSLR Profesional', 'Captura momentos con calidad profesional', 699.99, 849.99,  567658, 'Cámara', 'Empaque con pequeños rasguños'),
('37', 'Cámara Compacta de Viaje', 'Ideal para llevar en tus aventuras', 299.99, 599.99, 967890, 'Cámara', 'Caja con marcas de transporte'),
('38', 'Cámara Mirrorless de Alta Resolución', 'Compacta pero potente', 499.99, 649.99, 152365, 'Cámara', 'Etiqueta despegada'),
('39', 'Cámara de Acción Resistente al Agua', 'Perfecta para grabar tus deportes acuáticos', 9.99, 159.99, 548523, 'Cámara', 'Envase con pequeñas perforaciones'),
('40', 'Cámara Instantánea', 'Imprime tus recuerdos al instante', 29.99, 79.99, 654485, 'Cámara', 'Caja ligeramente dañada'),
('41', 'iPhone 13', 'Potente y elegante, con una increíble cámara', 649.99, 999.99, 865412, 'Móvil', 'Pequeña abolladura en la esquina inferior'),
('42', 'Samsung Galaxy S21', 'Diseño moderno y rendimiento excepcional', 549.99, 899.99, 456987, 'Móvil', 'Caja con marcas de manipulación');


-- Crear inventarios por categoría
INSERT INTO `inventario` (`cod_inventario`, `cod_empresa`, `descripcion`) VALUES
('1', '1', 'Videojuegos'),
('2', '1', 'TVs'),
('3', '1', 'Altavoces'),
('4', '1', 'Camisetas'),
('5', '1', 'Zapatillas Vans'),
('6', '1', 'Comida'),
('7', '1', 'Juguetes'),
('8', '1', 'Cámaras'),
('9', '1', 'Teléfonos Móviles');

INSERT INTO `inventario_productos` (`cod_inventario`, `cod_producto`, `cantidad`) VALUES
('1', '1', 10),
('1', '2', 5),
('1', '3', 15),
('1', '4', 5),
('1', '5', 6),
('2', '6', 12),
('2', '7', 4),
('2', '8', 5),
('2', '9', 6),
('2', '10', 5),
('3', '11', 14),
('3', '12', 4),
('3', '13', 5),
('3', '14', 6),
('3', '15', 2),
('4', '16', 4),
('4', '17', 5),
('4', '18', 1),
('4', '19', 6),
('4', '20', 10),
('5', '21', 13),
('5', '22', 4),
('5', '23', 5),
('5', '24', 6),
('5', '25', 3),
('6', '26', 7),
('6', '27', 12),
('6', '28', 11),
('6', '29', 4),
('6', '30', 4),
('7', '31', 8),
('7', '32', 13),
('7', '33', 1),
('7', '34', 4),
('7', '35', 5),
('8', '36', 6),
('8', '37', 5),
('8', '38', 10),
('8', '39', 14),
('8', '40', 4),
('9', '41', 5),
('9', '42', 6);



-- Restablecimiento de la configuración de caracteres y collation
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
