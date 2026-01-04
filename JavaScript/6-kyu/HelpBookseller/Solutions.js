// HelpBookseller - JavaScript
function stockList(listOfArt, listOfCat){
  if (!listOfArt.length || !listOfCat.length) return '';
  const counts = {};
  for (const item of listOfArt){
    const [code, qtyStr] = item.split(' ');
    const cat = code[0];
    const qty = parseInt(qtyStr, 10) || 0;
    counts[cat] = (counts[cat] || 0) + qty;
  }
  return listOfCat.map(c => `(${c} : ${counts[c] || 0})`).join(' - ');
}
module.exports = { stockList };
