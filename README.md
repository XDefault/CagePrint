<h1 align="center">
Cage Print
</h1>

<p align="center"> This is a very simple project to print anything in a caged box into a console.
</p>

---
 
<div align="center">

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)
</div>


# Table of Contents

- [Getting Started](#getting_started)
- [Usage](#usage)
- [Authors](#authors)

# Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project for development and testing purposes.

## Prerequisites

There are no prerequisites to use this project.

## Installing

### With the .jar
Download the .jar to your project and set the as a dependency within your IDE.
 
#### [IntelliJ](https://www.jetbrains.com/idea/)
```
File->Project Structure->Modules->Dependencies->Click the + button->Add the .jar
```

### Source Code
1. Clone the repository.
2. Open the project in your IDE of choice or copy the folder <b>[```com```](src/com)</b> to your <b>```src```</b> folder

# Usage <a name="usage"></a>

1. After setting up the .jar as a dependency or copying the folder to your project source folder, simply import the package to the file.

```
import com.xsdefault.cageprint.*;
```

---

2. Customize the colors of the cage, default text, drawing chars and offset padding if necessary.

```
CagePrint.cageColor = Colors.BLUE;
CagePrint.defaultTextColor = Colors.GREEN;
CagePrint.DrawChars = new char[]{'-', '|'};
CagePrint.cageSizeOffset = 10;
```

---
 
3. Add the items to be printed out with the alignment and color of text(optional).

```
CagePrint.addItemToDraw("Test", CagePrint.Align.MIDDLE,Colors.GREEN);
```
Or
```
int example = 10;
CagePrint.addItemToDraw(example, CagePrint.Align.MIDDLE,Colors.GREEN);
```
---

4. Then just call the method to draw the screen.
```
CagePrint.drawScreen();
```

---

5. Clear the list of itens to update the screen for the next frame. (Optional)
```
CagePrint.clearItems();
```

The source code contains a file with an [example](src/test/main/Main.java).

# Authors <a name = "authors"></a>

- [@XDefault](https://github.com/XDefault)