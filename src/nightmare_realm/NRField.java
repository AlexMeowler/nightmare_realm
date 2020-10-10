package nightmare_realm;
/**
	* Класс игрового поля, содержащего информацию о нем и методы взаимодействия с ним
	* @author Александр Ретивов
	* @version 1.0
*/
public class NRField 
{
	/** 
	 * Конструктор - создание нового объекта.
	 * Кодировка цветов в матрице поля: 0 - пусто, 1 - желтый, 2 - оранжевый, 3 - красный, 127 - блок
	*/
	
	public NRField()
	{
		field = new byte[field_size][field_size];
		colors = new byte[(field_size + 1) / 2];
	}
	/** 
	 * Функция получения значения из матрицы игрового поля {@link NRField#field}
	 * @param i - строка(отсчет ведется с 0)
	 * @param j - столбец(отсчет ведется с 0) 
	 * @return Возвращает значение элемента матрицы
	 * @see NRField#getField(int, int)
	*/
	public byte getField(int i, int j)
	{
		return field[i][j];
	}
	/** 
	 * Функция задания значения в матрице игрового поля {@link NRField#field}
	 * @param i - строка(отсчет ведется с 0)
	 * @param j - столбец(отсчет ведется с 0)
	 * @param key - значение, которое будет вставлено
	 * @see NRField#setField(int, int, byte) 
	*/
	public void setField(int i, int j, byte key)
	{
		field[i][j] = key;
	}
	
	/** 
	 * Функция получения цвета фишек, которыми необходимо заполнить один из столбцов{@link NRField#field}
	 * @param i - индекс массива(отсчет ведется с 0) 
	 * @return Возвращает код цвета
	*/
	public byte getColor(int i)
	{
		return colors[i];
	}
	/** 
	 * Функция конфигурации поля, как в тестовом задании
	*/
	public void setExampleConfig()
	{
		field[0][0] = 2;
		field[0][1] = 127;
		field[0][2] = 1;
		field[0][3] = 127;
		field[0][4] = 2;
		field[1][0] = 3;
		field[1][1] = 0;
		field[1][2] = 1;
		field[1][3] = 0;
		field[1][4] = 2;
		field[2][0] = 1;
		field[2][1] = 127;
		field[2][2] = 3;
		field[2][3] = 127;
		field[2][4] = 3;
		field[3][0] = 2;
		field[3][1] = 0;
		field[3][2] = 2;
		field[3][3] = 0;
		field[3][4] = 1;
		field[4][0] = 3;
		field[4][1] = 127;
		field[4][2] = 3;
		field[4][3] = 127;
		field[4][4] = 1;
		colors[0] = 1;
		colors[1] = 2;
		colors[2] = 3;
	}
	/** 
	 * Функция конфигурации поля, где от победы игрока отделяет 1 ход. Использовалась при тестировании для отладки условия завершения игры
	*/
	public void setWinCheckConfig()
	{
		field[0][0] = 1;
		field[0][1] = 127;
		field[0][2] = 2;
		field[0][3] = 127;
		field[0][4] = 3;
		field[1][0] = 1;
		field[1][1] = 0;
		field[1][2] = 2;
		field[1][3] = 0;
		field[1][4] = 3;
		field[2][0] = 1;
		field[2][1] = 127;
		field[2][2] = 2;
		field[2][3] = 127;
		field[2][4] = 3;
		field[3][0] = 1;
		field[3][1] = 0;
		field[3][2] = 2;
		field[3][3] = 3;
		field[3][4] = 0;
		field[4][0] = 1;
		field[4][1] = 127;
		field[4][2] = 2;
		field[4][3] = 127;
		field[4][4] = 3;
		colors[0] = 1;
		colors[1] = 2;
		colors[2] = 3;
	}
	/**
	 * Матрица, содержащая данные об игровом поле. Взаимодействие с ней должно осуществляться только через методы {@link NRField#setField(int, int, byte)} и {@link NRField#getField(int, int)}
	 */
	private byte[][] field;
	/**
	 * Массив с данными цветов, которыми надо заполнить столбцы
	 */
	private byte[] colors;
	/**
	 * Константа, задающая размер игрового поля
	 */
	public static final int field_size = 5;
	
}
