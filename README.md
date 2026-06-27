# Kalkulators

Vienkāršs grafisks kalkulators, rakstīts Java ar Swing bibliotēku.

## Ekrānuzņēmums

```
┌─────────────────────────┐
│                       0 │
├──────┬──────┬──────┬────┤
│  AC  │  +/- │  %   │  / │
│  7   │  8   │  9   │  x │
│  4   │  5   │  6   │  - │
│  1   │  2   │  3   │  + │
│ del  │  0   │  ,   │  = │
└──────┴──────┴──────┴────┘
```

## Funkcionalitāte

| Poga | Darbība |
|------|---------|
| `0`–`9` | Ciparu ievade |
| `,` | Decimālpunkts |
| `+` `-` `x` `/` | Saskaitīšana, atņemšana, reizināšana, dalīšana |
| `=` | Aprēķina rezultātu |
| `AC` | Notīra visu, atgriež sākotnējo stāvokli |
| `del` | Dzēš pēdējo ievadīto ciparu |
| `+/-` | Maina skaitļa zīmi |
| `%` | Pārvērš skaitli procentos (dala ar 100) |

**Dalīšana ar 0** tiek apstrādāta — displejs rāda `Kļūda`.

## Prasības

- **Java** 14 vai jaunāka (izmantots `switch` izteiksmes sintakse)
- Swing ir iekļauts JDK standarta bibliotēkā — papildus atkarības nav vajadzīgas

## Palaišana

### 1. Kompilēšana

```bash
javac -encoding UTF-8 Main.java
```

### 2. Palaišana

```bash
java Main
```

## Projekta struktūra

```
Kalkulators/
└── Main.java   # Viss kods — UI un loģika vienā failā
```

## Tehnoloģijas

- **Java** — galvenā programmēšanas valoda
- **javax.swing** — grafiskā lietotāja saskarne (JFrame, JButton, JTextField)
- **java.awt** — izkārtojuma pārvaldība (BorderLayout, GridLayout)
