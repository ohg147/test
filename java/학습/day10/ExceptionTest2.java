package day10;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�������");
		
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = num1 / num2;
			System.out.println("������ : " + result);
		} catch(Exception e) {
			System.out.println(e);
		}
		/*
			 * catch (ArrayIndexOutOfBoundsException e) {
			 * System.out.println("���α׷� �ƱԸ�Ʈ�� 2�� �����ϼ���");
			 * 
			 * } catch (ArithmeticException e) {
			 * System.out.println("2��° ���α׷� �ƱԸ�Ʈ�� 0�̾ƴ� ���� �����ϼ���");
			 * System.out.println(e.getMessage()); return; } catch (NumberFormatException e)
			 * { System.out.println("���α׷� �ƱԸ�Ʈ�� ���ڸ� �����ϼ���"); }
			 */finally {
			System.out.println("�׻����");
		}
		System.out.println("��������");

	}

}
