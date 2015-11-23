-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2015 at 04:48 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hrperformancemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `action`
--

CREATE TABLE IF NOT EXISTS `action` (
  `id` int(11) NOT NULL,
  `descriptionAction` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `action`
--

INSERT INTO `action` (`id`, `descriptionAction`) VALUES
(19, 'Action 1'),
(21, 'Action 2');

-- --------------------------------------------------------

--
-- Table structure for table `bap`
--

CREATE TABLE IF NOT EXISTS `bap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateBAP` datetime NOT NULL,
  `StatutBAP` varchar(128) NOT NULL,
  `idFicheObjectifsTraites` int(11) DEFAULT NULL,
  `idFicheObjectifsRediges` int(11) DEFAULT NULL,
  `idFicheEvaluations` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifsTraites` (`idFicheObjectifsTraites`),
  KEY `idFicheObjectifsRediges` (`idFicheObjectifsRediges`),
  KEY `idFicheEvaluations` (`idFicheEvaluations`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `bap`
--

INSERT INTO `bap` (`id`, `dateBAP`, `StatutBAP`, `idFicheObjectifsTraites`, `idFicheObjectifsRediges`, `idFicheEvaluations`) VALUES
(19, '2015-11-23 15:24:01', 'EN_COURS', 49, 50, 25);

-- --------------------------------------------------------

--
-- Table structure for table `bip`
--

CREATE TABLE IF NOT EXISTS `bip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateBIP` datetime NOT NULL,
  `idFicheObjectifsTraites` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifsTraites` (`idFicheObjectifsTraites`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `bip`
--

INSERT INTO `bip` (`id`, `dateBIP`, `idFicheObjectifsTraites`) VALUES
(10, '2015-11-23 15:24:05', 53);

-- --------------------------------------------------------

--
-- Table structure for table `collaborateur`
--

CREATE TABLE IF NOT EXISTS `collaborateur` (
  `id` int(11) NOT NULL,
  `id_manager` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_manager` (`id_manager`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `collaborateur`
--

INSERT INTO `collaborateur` (`id`, `id_manager`) VALUES
(131, 130),
(134, 133),
(137, 136),
(139, 138),
(143, 141);

-- --------------------------------------------------------

--
-- Table structure for table `entete`
--

CREATE TABLE IF NOT EXISTS `entete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebutIntervention` date DEFAULT NULL,
  `dateFinIntervention` date DEFAULT NULL,
  `role` varchar(64) DEFAULT NULL,
  `nombreJoursValorises` int(11) DEFAULT NULL,
  `idProjet` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `entete`
--

INSERT INTO `entete` (`id`, `dateDebutIntervention`, `dateFinIntervention`, `role`, `nombreJoursValorises`, `idProjet`) VALUES
(9, '2015-11-23', '2015-11-23', 'Rien', 20, 11),
(10, '2015-11-23', '2015-11-23', 'Rien', 20, 12),
(11, '2015-11-23', '2015-11-23', 'Rien', 20, 13),
(12, '2015-11-23', '2015-11-23', 'Rien', 20, 14),
(13, '2015-11-23', '2015-11-23', 'Rien 2', 25, 15),
(14, '2015-11-23', '2015-11-23', 'Rien', 20, 15),
(15, '2015-11-23', '2015-11-23', 'Rien', 20, 16),
(16, '2015-11-23', '2015-11-23', 'Rien 2', 25, 16),
(17, '2015-11-23', '2015-11-23', 'Rien', 20, 17),
(18, '2015-11-23', '2015-11-23', 'Rien 2', 25, 17),
(19, '2015-11-23', '2015-11-23', 'Rien 2', 25, 18),
(20, '2015-11-23', '2015-11-23', 'Rien', 20, 18),
(21, '2015-11-23', '2015-11-23', 'Rien 2', 25, 19),
(22, '2015-11-23', '2015-11-23', 'Rien', 20, 19);

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poids` int(11) NOT NULL,
  `resultat` double DEFAULT NULL,
  `idEncadrant` int(11) NOT NULL,
  `idObjectif` int(11) NOT NULL,
  `idFicheEvaluations` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEncadrant` (`idEncadrant`,`idObjectif`),
  KEY `foreign key` (`idObjectif`),
  KEY `idFicheEvaluations` (`idFicheEvaluations`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `evaluation`
--

INSERT INTO `evaluation` (`id`, `poids`, `resultat`, `idEncadrant`, `idObjectif`, `idFicheEvaluations`) VALUES
(27, 52, 215.3, 132, 136, 25),
(28, 5, 15.3, 132, 135, 25),
(29, 5, 15.3, 135, 141, 26),
(30, 52, 215.3, 135, 142, 26);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarqueGenerale` varchar(1024) NOT NULL,
  `validation` bit(1) NOT NULL,
  `idEntete` int(11) DEFAULT NULL,
  `idCollaborateur` int(11) NOT NULL,
  `idEndacrant` int(11) NOT NULL,
  `idBap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`),
  KEY `idEndacrant` (`idEndacrant`),
  KEY `idEntete` (`idEntete`),
  KEY `idBap` (`idBap`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `remarqueGenerale`, `validation`, `idEntete`, `idCollaborateur`, `idEndacrant`, `idBap`) VALUES
(20, 'Ceci est une remarque 2', b'0', 21, 131, 132, 19),
(21, 'Ceci est une remarque', b'1', 22, 131, 132, 19);

-- --------------------------------------------------------

--
-- Table structure for table `fiche_evaluations`
--

CREATE TABLE IF NOT EXISTS `fiche_evaluations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateEvaluation` datetime NOT NULL,
  `autorisationAcces` bit(1) DEFAULT b'1',
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `fiche_evaluations`
--

INSERT INTO `fiche_evaluations` (`id`, `dateEvaluation`, `autorisationAcces`, `idCollaborateur`) VALUES
(25, '2015-11-23 15:24:01', b'1', 131),
(26, '2015-11-23 15:24:05', b'1', 137);

-- --------------------------------------------------------

--
-- Table structure for table `fiche_objectifs`
--

CREATE TABLE IF NOT EXISTS `fiche_objectifs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateFicheObjectifs` datetime NOT NULL,
  `autorisationAcces` bit(1) NOT NULL DEFAULT b'1',
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign key` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=54 ;

--
-- Dumping data for table `fiche_objectifs`
--

INSERT INTO `fiche_objectifs` (`id`, `dateFicheObjectifs`, `autorisationAcces`, `idCollaborateur`) VALUES
(49, '2015-11-23 15:24:01', b'1', 131),
(50, '2015-11-23 15:24:01', b'0', 131),
(51, '2015-11-23 15:24:05', b'1', 134),
(52, '2015-11-23 15:24:05', b'1', 137),
(53, '2015-11-23 15:24:05', b'1', 139);

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL,
  `autoformation` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id`, `autoformation`) VALUES
(20, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `objectif`
--

CREATE TABLE IF NOT EXISTS `objectif` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionObjectif` varchar(512) NOT NULL,
  `mesureObjectif` varchar(512) NOT NULL,
  `avancementObjectif` double NOT NULL DEFAULT '0',
  `idFicheObjectifs` int(11) DEFAULT NULL,
  `idFormation` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifs` (`idFicheObjectifs`),
  KEY `idFormation` (`idFormation`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=147 ;

--
-- Dumping data for table `objectif`
--

INSERT INTO `objectif` (`id`, `descriptionObjectif`, `mesureObjectif`, `avancementObjectif`, `idFicheObjectifs`, `idFormation`, `idProjet`) VALUES
(135, 'Objectif 1', 'Mesuré par blabla', 5.66, 49, NULL, NULL),
(136, 'Objectif 2', 'Mesuré par blabla 2 :D', 115.66, 49, NULL, NULL),
(137, 'Objectif 5', 'Mesuré par blabla 5', 5.66, 50, NULL, NULL),
(138, 'Objectif 6', 'Mesuré par blabla 6 :D', 115.66, 50, NULL, NULL),
(139, 'Objectif 1', 'Mesuré par blabla', 5.66, 51, NULL, NULL),
(140, 'Objectif 2', 'Mesuré par blabla 2 :D', 115.66, 51, NULL, NULL),
(141, 'Objectif 1', 'Mesuré par blabla', 5.66, 52, NULL, NULL),
(142, 'Objectif 2', 'Mesuré par blabla 2 :D', 115.66, 52, NULL, NULL),
(143, 'Objectif 1', 'Mesuré par blabla', 5.66, 53, NULL, NULL),
(144, 'Objectif 2', 'Mesuré par blabla 2 :D', 115.66, 53, NULL, NULL),
(145, 'Objectif 3', 'Mesuré par blabla 3', 5.66, NULL, 20, NULL),
(146, 'Objectif 4', 'Mesuré par blabla 4 :D', 115.66, NULL, 20, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `plan_amelioration`
--

CREATE TABLE IF NOT EXISTS `plan_amelioration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idBip` int(11) NOT NULL,
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_collaborateur` (`idCollaborateur`),
  KEY `id_bip` (`idBip`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `plan_amelioration`
--

INSERT INTO `plan_amelioration` (`id`, `idBip`, `idCollaborateur`) VALUES
(19, 10, 139),
(20, 10, 139),
(21, 10, 139);

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeProfile` varchar(16) NOT NULL,
  `descriptionProfile` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codeProfile` (`codeProfile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeProjet` varchar(16) NOT NULL,
  `nomProjet` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `codeProjet`, `nomProjet`) VALUES
(11, 'AB', 'blabla'),
(12, 'AB', 'blabla'),
(13, 'AB', 'blabla'),
(14, 'AB', 'blabla'),
(15, 'AB', 'blabla'),
(16, 'AB', 'blabla'),
(17, 'AB', 'blabla'),
(18, 'AB', 'blabla'),
(19, 'AB', 'blabla');

-- --------------------------------------------------------

--
-- Table structure for table `qualification_theme`
--

CREATE TABLE IF NOT EXISTS `qualification_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(128) NOT NULL,
  `qualification` varchar(128) NOT NULL,
  `remarque` varchar(512) DEFAULT NULL,
  `idFeedback` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFeedback` (`idFeedback`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `qualification_theme`
--

INSERT INTO `qualification_theme` (`id`, `theme`, `qualification`, `remarque`, `idFeedback`) VALUES
(40, 'POLYVALENCE', 'SELON_ATTENTE', '', 20),
(41, 'GESTION_DE_RELATION_CLIENT', 'CRITIQUE', 'Une remarque 3', 21),
(42, 'GESTION_DE_PROJET', 'SELON_ATTENTE', '', 21),
(43, 'CONCEPTION', 'A_DEVELOPPER', 'Une remarque', 21);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL,
  `motDePasse` varchar(128) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `prenom` varchar(64) NOT NULL,
  `typeUtilisateur` varchar(2) NOT NULL DEFAULT 'C',
  `idProfile` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `idProfile` (`idProfile`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=144 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `nom`, `prenom`, `typeUtilisateur`, `idProfile`) VALUES
(130, 'manager5@mail.com', 'motDePasseManager2', 'nomManager2', 'prenomManager2', 'M', NULL),
(131, 'collaborateur5@mail.com', 'motDePasseCollaborateur2', 'nomCollaborateur2', 'prenomCollaborateur2', 'C', NULL),
(132, 'encadrant5@mail.com', 'motDePasseEncadrant', 'nomEncadrant', 'prenomEncadrant', 'E', NULL),
(133, 'manager2@mail.com', 'motDePasseManager2', 'nomManager2', 'prenomManager2', 'M', NULL),
(134, 'collaborateur2@mail.com', 'motDePasseCollaborateur2', 'nomCollaborateur2', 'prenomCollaborateur2', 'C', NULL),
(135, 'encadrant3@mail.com', 'motDePasseEncadrant', 'nomEncadrant', 'prenomEncadrant', 'E', NULL),
(136, 'manager3@mail.com', 'motDePasseManager2', 'nomManager2', 'prenomManager2', 'M', NULL),
(137, 'collaborateur3@mail.com', 'motDePasseCollaborateur2', 'nomCollaborateur2', 'prenomCollaborateur2', 'C', NULL),
(138, 'manager4@mail.com', 'motDePasseManager2', 'nomManager2', 'prenomManager2', 'M', NULL),
(139, 'collaborateur4@mail.com', 'motDePasseCollaborateur2', 'nomCollaborateur2', 'prenomCollaborateur2', 'C', NULL),
(140, 'admin@mail.com', 'motDePasseAdmin', 'nomAdmin', 'prenomAdmin', 'A', NULL),
(141, 'manager@mail.com', 'motDePasseManager', 'nomManager', 'prenomManager', 'M', NULL),
(142, 'encadrant@mail.com', 'motDePasseEncadrant', 'nomEncadrant', 'prenomEncadrant', 'E', NULL),
(143, 'collaborateur@mail.com', 'motDePasseCollaborateur', 'nomCollaborateur', 'prenomCollaborateur', 'C', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `action_ibfk_1` FOREIGN KEY (`id`) REFERENCES `plan_amelioration` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bap`
--
ALTER TABLE `bap`
  ADD CONSTRAINT `bap_ibfk_4` FOREIGN KEY (`idFicheObjectifsTraites`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bap_ibfk_2` FOREIGN KEY (`idFicheObjectifsRediges`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bap_ibfk_3` FOREIGN KEY (`idFicheEvaluations`) REFERENCES `fiche_evaluations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bip`
--
ALTER TABLE `bip`
  ADD CONSTRAINT `bip_ibfk_1` FOREIGN KEY (`idFicheObjectifsTraites`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD CONSTRAINT `collaborateur_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `collaborateur_ibfk_2` FOREIGN KEY (`id_manager`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `entete`
--
ALTER TABLE `entete`
  ADD CONSTRAINT `entete_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`);

--
-- Constraints for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evaluation_ibfk_2` FOREIGN KEY (`idObjectif`) REFERENCES `objectif` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evaluation_ibfk_3` FOREIGN KEY (`idFicheEvaluations`) REFERENCES `fiche_evaluations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`idEndacrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `feedback_ibfk_3` FOREIGN KEY (`idEntete`) REFERENCES `entete` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `feedback_ibfk_4` FOREIGN KEY (`idBap`) REFERENCES `bap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fiche_evaluations`
--
ALTER TABLE `fiche_evaluations`
  ADD CONSTRAINT `fiche_evaluations_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fiche_objectifs`
--
ALTER TABLE `fiche_objectifs`
  ADD CONSTRAINT `fiche_objectifs_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `plan_amelioration` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `objectif`
--
ALTER TABLE `objectif`
  ADD CONSTRAINT `objectif_ibfk_1` FOREIGN KEY (`idFicheObjectifs`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `objectif_ibfk_2` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`),
  ADD CONSTRAINT `objectif_ibfk_3` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `plan_amelioration`
--
ALTER TABLE `plan_amelioration`
  ADD CONSTRAINT `plan_amelioration_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `plan_amelioration_ibfk_2` FOREIGN KEY (`idBip`) REFERENCES `bip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `qualification_theme`
--
ALTER TABLE `qualification_theme`
  ADD CONSTRAINT `qualification_theme_ibfk_1` FOREIGN KEY (`idFeedback`) REFERENCES `feedback` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`idProfile`) REFERENCES `profile` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
