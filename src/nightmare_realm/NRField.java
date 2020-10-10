package nightmare_realm;
/**
	* ����� �������� ����, ����������� ���������� � ��� � ������ �������������� � ���
	* @author ��������� �������
	* @version 1.0
*/
public class NRField 
{
	/** 
	 * ����������� - �������� ������ �������.
	 * ��������� ������ � ������� ����: 0 - �����, 1 - ������, 2 - ���������, 3 - �������, 127 - ����
	*/
	
	public NRField()
	{
		field = new byte[field_size][field_size];
		colors = new byte[(field_size + 1) / 2];
	}
	/** 
	 * ������� ��������� �������� �� ������� �������� ���� {@link NRField#field}
	 * @param i - ������(������ ������� � 0)
	 * @param j - �������(������ ������� � 0) 
	 * @return ���������� �������� �������� �������
	 * @see NRField#getField(int, int)
	*/
	public byte getField(int i, int j)
	{
		return field[i][j];
	}
	/** 
	 * ������� ������� �������� � ������� �������� ���� {@link NRField#field}
	 * @param i - ������(������ ������� � 0)
	 * @param j - �������(������ ������� � 0)
	 * @param key - ��������, ������� ����� ���������
	 * @see NRField#setField(int, int, byte) 
	*/
	public void setField(int i, int j, byte key)
	{
		field[i][j] = key;
	}
	
	/** 
	 * ������� ��������� ����� �����, �������� ���������� ��������� ���� �� ��������{@link NRField#field}
	 * @param i - ������ �������(������ ������� � 0) 
	 * @return ���������� ��� �����
	*/
	public byte getColor(int i)
	{
		return colors[i];
	}
	/** 
	 * ������� ������������ ����, ��� � �������� �������
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
	 * ������� ������������ ����, ��� �� ������ ������ �������� 1 ���. �������������� ��� ������������ ��� ������� ������� ���������� ����
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
	 * �������, ���������� ������ �� ������� ����. �������������� � ��� ������ �������������� ������ ����� ������ {@link NRField#setField(int, int, byte)} � {@link NRField#getField(int, int)}
	 */
	private byte[][] field;
	/**
	 * ������ � ������� ������, �������� ���� ��������� �������
	 */
	private byte[] colors;
	/**
	 * ���������, �������� ������ �������� ����
	 */
	public static final int field_size = 5;
	
}
