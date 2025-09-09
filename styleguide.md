FeastForward Style Guide (Based on Current Code)
1️⃣ Color Palette
Purpose	Color	Tailwind Class
Primary Green	#16A34A	bg-green-600, text-green-600, hover:bg-green-700
Secondary Yellow (Volunteer)	#F59E0B	bg-yellow-500, hover:bg-yellow-600
Background Gray	#F9FAFB	bg-gray-50
Card Background	White	bg-white
Footer	Dark Gray	bg-gray-800, text-white
Text Gray	#4B5563	text-gray-600
Text Dark Gray	#1F2937	text-gray-800
2️⃣ Typography
Element	Tailwind Classes	Notes
Page Title / Hero Heading	text-4xl font-bold text-green-700	Large, bold, primary color
Section Headings	text-2xl font-bold text-green-700	Used for About, How It Works, Roles
Card Headings	text-xl font-semibold text-green-600	Slightly smaller, bold
Body Text	text-gray-600	Standard paragraph text
Footer Text	text-white or text-sm	Small and subtle

Font: Use default Tailwind font (sans-serif) or add Google Fonts (Inter or Roboto) for a modern look.

3️⃣ Spacing & Layout

Container max-widths: max-w-7xl (Navbar, Footer), max-w-6xl (main sections)

Padding:

Sections: py-12 or py-16

Cards: p-6

Buttons: px-4 py-2 or px-6 py-2

Margins:

Headings: mt-4

Between buttons: mt-6 or space-x-4

Flex & Grid:

Navbar: flex justify-between items-center

Roles / How It Works sections: grid md:grid-cols-3 gap-8 → responsive columns

Footer: flex flex-col md:flex-row justify-between items-center → responsive stacking

4️⃣ Buttons
Type	Classes	Notes
Primary (Donate / Find Food)	bg-green-600 text-white px-6 py-2 rounded-lg hover:bg-green-700	CTA buttons
Secondary (Volunteer / Yellow)	bg-yellow-500 text-white px-6 py-2 rounded-lg hover:bg-yellow-600	Volunteer CTA
Alternative (Outline / White)	bg-white border border-green-600 text-green-600 px-6 py-2 rounded-lg hover:bg-green-50	Secondary CTA

Shape: Rounded (rounded-lg)
Hover effect: Slightly darker background

5️⃣ Cards

Container: bg-white p-6 rounded-xl shadow-md

Heading: text-xl font-semibold text-green-600

Paragraph: mt-2 text-gray-600

CTA inside card: use buttons described above

Notes: Keep uniform height for cards in the same row if possible (can use flex flex-col justify-between).

6️⃣ Navbar

Background: bg-white

Shadow: shadow-md

Links: text-gray-700 hover:text-green-600

CTA (Login): bg-green-600 text-white px-3 py-1 rounded-lg hover:bg-green-700

Layout: flex justify-between items-center

7️⃣ Footer

Background: bg-gray-800

Text: text-white

Layout: flex flex-col md:flex-row justify-between items-center

Padding: py-6

Small tagline: font-semibold

8️⃣ Responsiveness

Use md: prefixes for medium screens and above:

Grid layout → md:grid-cols-3

Footer → md:flex-row

Mobile-friendly defaults (stacking vertically):

flex-col on mobile

mt-2 spacing between stacked elements